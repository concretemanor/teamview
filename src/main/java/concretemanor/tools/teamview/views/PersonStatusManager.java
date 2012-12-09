package concretemanor.tools.teamview.views;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;

import net.sourceforge.stripes.util.Log;
import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Status;

/**
 * Manager class that is used to access a "database" of mapping from people to (date,status) pairs.
 */
public class PersonStatusManager {
	private static Log loggie = Log.getInstance(PersonStatusManager.class);
	
	/** Stores the list of people in the system. */
	private static Map<Person,Map<Date,Status>> data = new TreeMap<Person,Map<Date,Status>>();

	private Map<Date,Status> getDsMap(Person person) {
		Map<Date,Status> dsMap = data.get(person);
		if (dsMap == null) {
			dsMap = new TreeMap<Date,Status>();
			data.put(person,dsMap);
		}
		
		return dsMap;
	}

	/*
	 * Return person's status for the specified Monday through Friday
	 */
	public Status[] getForWeek(Person person,Date monday) {
		loggie.debug("data "+data);
		Map<Date,Status> dsMap = getDsMap(person);
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(monday);
		Status[] result = new Status[5];
		for (int i=0; i<5; i++) {
			Date date = gCal.getTime();
			Status status = dsMap.get(date);
			if (status == null) {
				status = Status.IN_OFFICE;
			}
			result[i] = status;
			gCal.add(Calendar.DAY_OF_MONTH,1);
		}

		loggie.debug("getForWeek("+person+" "+monday+" returns "+Arrays.asList(result));
		return result;
	}

	/*
	 * Save the status for this person on this date.
	 */
	public void save(Person person,Date date,Status status) {
		Map<Date,Status> dsMap = getDsMap(person);
		dsMap.put(date,status);
	}
}
