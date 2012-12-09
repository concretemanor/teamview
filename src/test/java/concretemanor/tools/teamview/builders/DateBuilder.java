package concretemanor.tools.teamview.builders;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * User: shin4590
 * Date: 12/9/12
 */
public class DateBuilder {
    private Calendar calendar;

    private DateBuilder() {}

    public static DateBuilder newBuilder() {
        DateBuilder builder = new DateBuilder();
        builder.calendar = new GregorianCalendar();
        return builder;
    }

    public DateBuilder withYear(int year) {
        calendar.set(Calendar.YEAR, year);
        return this;
    }

    public DateBuilder withMonth(int month) {
        calendar.set(Calendar.MONTH, month);
        return this;
    }

    public DateBuilder withDayOfMonth(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return this;
    }

    public Date create() {
        return calendar.getTime();
    }
}
