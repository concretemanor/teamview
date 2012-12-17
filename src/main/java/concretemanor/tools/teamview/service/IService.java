package concretemanor.tools.teamview.service;

import java.util.Date;
import java.util.List;

import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Status;
import concretemanor.tools.teamview.domain.Team;

public interface IService {
	public List<Team> getAllTeams();
	
	public List<Person> getByTeam(Team team);
	
	public Team getTeamById(Integer teamId);
	
	public List<WeekStatus> getByTeamForWeek(Team team, Date sunday);
	
	public void updateStatus(Integer personId,Date date,Status status);
}
