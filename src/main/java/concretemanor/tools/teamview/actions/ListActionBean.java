package concretemanor.tools.teamview.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.util.Log;

public abstract class ListActionBean extends StatusContextActionBean implements ActionBean {
	static Log log = Log.getInstance(ListActionBean.class);
	
	private Resolution adjustDate(int delta) {
		setDate(dateFrom(delta));
		return refresh();
	}

	public Resolution back() {
		log.debug("in back");
		return adjustDate(-7);
	}

	public Resolution forward() {
		log.debug("in forward");
		return adjustDate(7);
	}

	@DefaultHandler
	public Resolution view() {
		log.debug("enter view");
	
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
}
