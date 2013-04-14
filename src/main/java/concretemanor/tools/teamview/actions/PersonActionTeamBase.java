package concretemanor.tools.teamview.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import net.sourceforge.stripes.action.ActionBean;

public class PersonActionTeamBase extends ActionBeanBase implements ActionBean {

    private Date date;
    
    public PersonActionTeamBase() {
        super();
    }

    // Maint note: probably should be a static method of a utility class
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