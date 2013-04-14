package concretemanor.tools.teamview.actions.admin;

import java.util.List;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;
import concretemanor.tools.teamview.actions.ActionBeanBase;
import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Team;

@UrlBinding("/a/admin/EditMembers")
public class EditMembersActionBean extends ActionBeanBase implements ActionBean {
	private static final Log log = Log.getInstance(EditMembersActionBean.class);
	
	private Team team;
	public void setTeam(Team team) {
		log.debug("setTeam: team="+team);
		this.team = team;
	}
	public Team getTeam() {
		return team;
	}
	
	public List<Person> getMembers() {
		List<Person> result = getService().getByTeam(team);
		//TBD: sort by name
		
		return result;
	}
	
	private Person thisMember;
	public void setThisMember(Person thisMember) {
		this.thisMember = thisMember;
	}
	public Person getThisMember() {
		return thisMember;
	}
	
	@DefaultHandler
	public Resolution preEdit() {
		setTeam(getService().getTeamById(team.getId()));
		thisMember = null;
		return new ForwardResolution("/members.jsp");
	}
	
	public Resolution add() {
		setTeam(getService().getTeamById(team.getId()));
		Person person = getService().getPersonByName(thisMember.getName());
		if (person == null) {
			person = new Person();
			person.setName(thisMember.getName());
			getService().updatePerson(person);
		}
		getService().addToTeam(person,getTeam());
		thisMember = null;
		return new ForwardResolution("/members.jsp");
	}
	
	public Resolution preRemove() {
		setTeam(getService().getTeamById(team.getId()));
		setThisMember(getService().getPersonById(thisMember.getId()));
		return new ForwardResolution("/removeMember.jsp");
	}
	
	public Resolution remove() {
		log.debug("attempting to remove "+thisMember+" from "+team);
		setTeam(getService().getTeamById(team.getId()));
		setThisMember(getService().getPersonById(thisMember.getId()));
		getService().removeFromTeam(getThisMember(), getTeam());
		thisMember = null;
		return new ForwardResolution("/members.jsp");
	}
}
