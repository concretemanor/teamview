package concretemanor.tools.teamview.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.util.Log;

import org.springframework.transaction.annotation.Transactional;

import concretemanor.tools.teamview.domain.Status;
import concretemanor.tools.teamview.domain.Team;
import concretemanor.tools.teamview.service.IService;
import concretemanor.tools.teamview.service.WeekStatus;
import concretemanor.tools.teamview.views.PersonManager;
import concretemanor.tools.teamview.views.PersonStatusManager;

@UrlBinding("/list.action")
public class ListActionBean implements ActionBean {
	private static Log loggie = Log.getInstance(ListActionBean.class);

	private ActionBeanContext context;

	@SpringBean
	private IService service;
	private PersonManager pm = new PersonManager();
	private PersonStatusManager psm = new PersonStatusManager();
	
	@Override
	public void setContext(ActionBeanContext context) {
		this.context = context;
	}

	@Override
	public ActionBeanContext getContext() {
		return context;
	}
	
	protected IService getService() {
		return service;
	}
	
	private Integer teamId = 1;
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		loggie.debug("setTeam: teamId="+teamId);
		this.teamId = teamId;
	}

	private Date date;

	public Date getDate() {
		return date;
	}

	private Date toMidnight(Date d) {
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(d);
		gCal.set(Calendar.HOUR_OF_DAY,0);
		gCal.set(Calendar.MINUTE,0);
		gCal.set(Calendar.SECOND,0);
		gCal.set(Calendar.MILLISECOND,0);

		return gCal.getTime();
	}
		
	public void setDate(Date date) {
		this.date = toMidnight(date);
	}

	private Date dateFrom(int delta) {
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(getDate());
		gCal.add(Calendar.DAY_OF_YEAR, delta);
		return gCal.getTime();
	}

	public Date getMonday() {
		return dateFrom(1);
	}

	public Date getTuesday() {
		return dateFrom(2);
	}

	public Date getWednesday() {
		return dateFrom(3);
	}

	public Date getThursday() {
		return dateFrom(4);
	}

	public Date getFriday() {
		return dateFrom(5);
	}

	public Date getLastDate() {
		return dateFrom(6);
	}

	public List<Team> getAllTeams() {
		List<Team> result = service.getAllTeams();
		return result;
	}
	
	public List<WeekStatus> getWeekStatuses() {
		Team team = service.getTeamById(teamId);
		List<WeekStatus> result = service.getByTeamForWeek(team,date);
		loggie.debug("getWeekStatuses returns "+result);

		return result;
	}

	private Status cellValue;
	public void setCellValue(Status cellValue) {
		this.cellValue = cellValue;
	}

	private String cellId;
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	private Resolution adjustDate(int delta) {
		setDate(dateFrom(delta));
		return refresh();
	}

	public Resolution back() {
		loggie.debug("in back");
		return adjustDate(-7);
	}

	public Resolution forward() {
		loggie.debug("in forward");
		return adjustDate(7);
	}

	public Resolution refresh() {
		return new ForwardResolution("/main.jsp");
	}

	@DefaultHandler
	public Resolution view() {
		if ("changeStatus".equals(event)) { // TBD remove this hack
			return changeStatus();
		}
		else if ("changeTeam".equals(event)) {
			return changeTeam();
		}

		loggie.debug("in view");
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(new Date());
		// if today is Saturday, go forward a day; otherwise find the most recent Sunday
		if (gCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			gCal.add(Calendar.DAY_OF_YEAR, 1);
		}
		else {
			while (gCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				gCal.add(Calendar.DAY_OF_YEAR, -1);
			}
		}
		setDate(gCal.getTime());

		return refresh();
	}

	private String event;
	public void setEvent(String event) {
		this.event = event;
	}

	public Resolution changeStatus() {
		int personId = Integer.valueOf(cellId.substring(1));
		int dayIndex = Integer.valueOf(cellId.substring(0,1));
		Date date = dateFrom(dayIndex);
		loggie.debug("update "+personId+" "+dayIndex+" "+date+" "+cellValue);
		service.updateStatus(personId,date,cellValue);

		return refresh();
	}
	
	public Resolution changeTeam() {
		loggie.debug("team changed to "+teamId);
		return refresh();
	}
}
