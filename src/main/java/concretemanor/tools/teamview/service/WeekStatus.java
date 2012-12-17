package concretemanor.tools.teamview.service;

import java.util.Arrays;

import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Status;

public class WeekStatus {
	private Person person;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	private Status[] statuses;
	public Status[] getStatuses() {
		return statuses;
	}
	public void setStatuses(Status[] statuses) {
		this.statuses = statuses;
	}
	
	public String toString() {
		return person + " " + Arrays.asList(statuses);
	}
}
