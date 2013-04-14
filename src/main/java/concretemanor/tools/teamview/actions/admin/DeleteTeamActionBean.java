package concretemanor.tools.teamview.actions.admin;

import java.util.List;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;
import concretemanor.tools.teamview.actions.ActionBeanBase;
import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Team;

@UrlBinding("/a/admin/DeleteTeam")
public class DeleteTeamActionBean extends ActionBeanBase implements ActionBean {
	private static final Log log = Log.getInstance(DeleteTeamActionBean.class);
	
	protected Team loadTeam() {
		return getService().getTeamById(team.getId());
	}
	
	private Team team;
	public Team getTeam() {
		log.debug("getTeam will return "+team);
		return team;
	}
	public void setTeam(Team team) {
		log.debug("setTeam: team="+team);
		this.team = team;
	}
	
	@DefaultHandler
	public Resolution preEdit() {
		setTeam(loadTeam());
		return new ForwardResolution("/deleteTeam.jsp");
	}
	
	@HandlesEvent("save")
	public Resolution save() {
		// Remove everyone from the team.  Seems like there ought to be a "cascading delete" annotation 
		// for this but I can't find it
		Team t = loadTeam();
		List<Person> members = getService().getByTeam(t);
		for (Person p : members) {
			getService().removeFromTeam(p,t);
		}
		
		// Delete the (empty) team
		getService().deleteTeam(loadTeam());
		return new RedirectResolution(ListTeamsActionBean.class);
	}
}
