package concretemanor.tools.teamview.actions.admin;

import java.util.List;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;
import concretemanor.tools.teamview.actions.ActionBeanBase;
import concretemanor.tools.teamview.actions.TeamUtil;
import concretemanor.tools.teamview.domain.Team;

@UrlBinding("/a/admin/ListTeams")
public class ListTeamsActionBean extends ActionBeanBase implements ActionBean {
	private static final Log log = Log.getInstance(ListTeamsActionBean.class);
	
	private Team newTeam;
	public Team getNewTeam() {
		return newTeam;
	}
	public void setNewTeam(Team newTeam) {
		log.debug("set new team: "+newTeam);
		this.newTeam = newTeam;
	}
	
	public List<Team> getAllTeams() {
		List<Team> result = getService().getAllTeams();
		TeamUtil.sortTeamsByName(result);

		return result;
	}
	
	@DefaultHandler
	public Resolution view() {
		return new ForwardResolution("/teams.jsp");
	}
	
	public Resolution add() {
		log.debug("add team "+newTeam);
		getService().updateTeam(newTeam);
		newTeam = null;
		return new ForwardResolution("/teams.jsp");
	}
	
}
