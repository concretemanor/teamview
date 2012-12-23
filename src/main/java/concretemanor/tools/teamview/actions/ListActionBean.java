package concretemanor.tools.teamview.actions;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.util.Log;

import com.google.gson.Gson;

import concretemanor.tools.teamview.domain.Team;
import concretemanor.tools.teamview.service.IService;
import concretemanor.tools.teamview.service.WeekStatus;

@UrlBinding("/list.action")
public class ListActionBean extends ActionBeanBase implements ActionBean {
	private static Log loggie = Log.getInstance(ListActionBean.class);

	@SpringBean
	private IService service;
	
	protected IService getService() {
		return service;
	}
	
	private Integer teamId = null;
	public Integer getTeamId() {
	    if (teamId == null) {
			teamId = service.getAllTeams().get(0).getId();
		}
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		loggie.debug("setTeam: teamId="+teamId);
		this.teamId = teamId;
	}

	public Date getLastDate() {
		return dateFrom(6);
	}

	public List<Team> getAllTeams() {
		List<Team> result = service.getAllTeams();
		return result;
	}
	
	private List<WeekStatus> getWeekStatuses() {
		Team team = service.getTeamById(teamId);
		List<WeekStatus> result = service.getByTeamForWeek(team,getDate());
		loggie.debug("getWeekStatuses returns "+result);

		return result;
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
		if ("changeTeam".equals(event)) {
			return changeTeam();
		}
		else if ("loadData".equals(event)) {
			return loadData();
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

	public Resolution changeTeam() {
		loggie.debug("team changed to "+teamId);
		return refresh();
	}
	
	public Resolution loadData() {
		loggie.debug("enter loadData");
		
		final Map<String,String> choices = new HashMap<String,String>();
		choices.put("IN_OFFICE", "In");
		choices.put("WORKING_REMOTELY", "Remote");
		choices.put("IN_TRAINING", "Training");
		choices.put("VACATION", "Off");
		
		final List<Map<String,Object>> metadata = new ArrayList<Map<String,Object>>();
		Map<String,Object> h = new HashMap<String,Object>();
		h.put("name","name");
		h.put("datatype","string");
		h.put("editable",Boolean.FALSE);
		h.put("label","");
		metadata.add(h);
		
		final SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd");
		for (int i=1; i<=5; i++) {
			final int j=i; // stupid hack -- what's the right way to do this?
			h = new HashMap<String,Object>();
		    h.put("name","d"+j);
			h.put("label",sdf.format(dateFrom(j)));
			h.put("datatype","string");
			h.put("editable",Boolean.TRUE);
			h.put("values",choices);
			metadata.add(h);
		}
		
		List<WeekStatus> statuses = getWeekStatuses();
		final List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		for (final WeekStatus status : statuses) {
			Map<String,Object> row = new HashMap<String,Object>();
			Map<String,Object> values = new HashMap<String,Object>();
			row.put("id",status.getPerson().getId());
			values.put("name",status.getPerson().getName());
			for (int i=0; i<5; i++) {
				values.put("d"+(i+1),status.getStatuses()[i]);
			}
			row.put("values", values);
			data.add(row);
		}
		
		Gson gson = new Gson();
		gson = new Gson();
		
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("metadata",metadata);
		model.put("data",data);
		
		String json = gson.toJson(model);
		
		return new StreamingResolution("text",new StringReader(json));
	}
}
