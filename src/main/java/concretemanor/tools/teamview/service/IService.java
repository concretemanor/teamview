package concretemanor.tools.teamview.service;

import java.util.Date;
import java.util.List;

import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Status;
import concretemanor.tools.teamview.domain.Team;

public interface IService {
	public List<Team> getAllTeams();
	
	public List<Person> getByTeam(Team team);
	
	public List<Person> getByNotTeam(Team team,String namePrefix,int maxRows);
	
	public Team getTeamById(Integer teamId);
	
	public Team getTeamByName(String name);
	
	public void updateTeam(Team team);
	
	public void deleteTeam(Team team);
	
	public List<WeekStatus> getByTeamForWeek(Team team, Date sunday);
	
	public void updateStatus(Integer personId,Date date,Status status);
	
	public Person getPersonById(Integer personId);
	
	public Person getPersonByName(String name);
	
	public void updatePerson(Person person);
	
	public Person addToTeam(Person person,Team team);
	
	public Person removeFromTeam(Person person,Team team);
	
	public Person addPerson(String name);
	
}
