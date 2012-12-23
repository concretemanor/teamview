package concretemanor.tools.teamview.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;


@UrlBinding("/list.action")
public class ListActionBean extends StatusContextActionBean implements ActionBean {
	static Log loggie = Log.getInstance(ListActionBean.class);
	
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

	@DefaultHandler
	public Resolution view() {
		loggie.debug("enter view");
	
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
