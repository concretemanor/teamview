package concretemanor.tools.teamview.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.stripes.util.Log;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import concretemanor.tools.teamview.dao.PersonDao;
import concretemanor.tools.teamview.dao.PersonStatusDao;
import concretemanor.tools.teamview.dao.TeamDao;
import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.PersonStatus;
import concretemanor.tools.teamview.domain.Status;
import concretemanor.tools.teamview.domain.Team;
import concretemanor.tools.teamview.service.IService;
import concretemanor.tools.teamview.service.WeekStatus;

@Service
public class ServiceImpl implements IService {
	private static Log loggie = Log.getInstance(ServiceImpl.class);

	@Autowired
	private TeamDao tDao;
	
	@Autowired
	private PersonDao pDao;
	
	@Autowired
	private PersonStatusDao psDao;

	@Override
	@Transactional
	public List<Team> getAllTeams() {
		List<Team> result = tDao.getAll();
		loggie.debug("getAllTeams result "+result);
		return result;
	}

	@Override
	@Transactional
	public List<Person> getByTeam(Team team) {
		List<Person> result = pDao.getByTeam(team);
		loggie.debug("getByTeam returns "+result);
		return result;
	}
	
	@Override
	@Transactional
	public List<WeekStatus> getByTeamForWeek(Team team, Date sunday) {
		loggie.debug("getByTeamForWeek: team "+team+ " sunday " + sunday);
		List<Person> people = getByTeam(team);
		Map<Person,ArrayList<Status>> resultMap = new HashMap<Person,ArrayList<Status>>();
		for (Person person : people) {
			ArrayList<Status> theirStatuses = new ArrayList<Status>();
			for (int i=0; i<5; i++) {
				theirStatuses.add(Status.IN_OFFICE);
			}
			resultMap.put(person, theirStatuses);
		}
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(sunday);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date monday = cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, 4);
		Date friday = cal.getTime();
		List<PersonStatus> statuses = psDao.getByTeamAndDateRange(team, monday, friday);
		loggie.debug("getByTeamAndDateRange "+team+" "+monday+" "+friday+" returned "+statuses);
		
		DateTime firstDateTime = new DateTime(monday.getTime());
		
		for (PersonStatus ps : statuses) {
			ArrayList<Status> theirStatuses = resultMap.get(ps.getPerson());
			DateTime thisDateTime = new DateTime(ps.getDateOfStatus().getTime());
			theirStatuses.set(Days.daysBetween(firstDateTime, thisDateTime).getDays(),ps.getStatus());
		}
		
		List<WeekStatus> result = new ArrayList<WeekStatus>();
		for (Person person : people) {
			WeekStatus ws = new WeekStatus();
			ws.setPerson(person);
			ws.setStatuses(resultMap.get(person).toArray(new Status[0]));
			result.add(ws);
		}
		
		return result;
	}
	
	@Override
	@Transactional
	public Team getTeamById(Integer id) {
		Team result = tDao.get(id);
		return result;
	}

	@Override
	@Transactional
	public void updateStatus(Integer personId, Date date, Status status) {
		PersonStatus ps = new PersonStatus();
		ps.setPerson(pDao.get(personId));
		ps.setDateOfStatus(date);
		ps.setStatus(status);
		psDao.save(ps);
	}

}
