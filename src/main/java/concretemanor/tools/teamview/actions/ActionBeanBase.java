package concretemanor.tools.teamview.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.integration.spring.SpringBean;
import concretemanor.tools.teamview.service.IService;

public class ActionBeanBase implements ActionBean {

	private ActionBeanContext context;
	private Date date;
	@SpringBean
	private IService service;
	
	public ActionBeanBase() {
		super();
	}

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

	protected Date toMidnight(Date d) {
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(d);
		gCal.set(Calendar.HOUR_OF_DAY,0);
		gCal.set(Calendar.MINUTE,0);
		gCal.set(Calendar.SECOND,0);
		gCal.set(Calendar.MILLISECOND,0);
	
		return gCal.getTime();
	}

	protected Date dateFrom(int delta) {
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(getDate());
		gCal.add(Calendar.DAY_OF_YEAR, delta);
		return gCal.getTime();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = toMidnight(date);
	}

}