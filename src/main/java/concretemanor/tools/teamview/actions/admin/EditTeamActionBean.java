package concretemanor.tools.teamview.actions.admin;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;
import concretemanor.tools.teamview.actions.ActionBeanBase;
import concretemanor.tools.teamview.domain.Team;

@UrlBinding("/a/admin/EditTeam")
public class EditTeamActionBean extends ActionBeanBase implements ActionBean {
	private static final Log log = Log.getInstance(EditTeamActionBean.class);
	
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
		return new ForwardResolution("/editTeam.jsp");
	}
	
	@ValidationMethod(on="save")
	public void checkNameUniqueness(ValidationErrors errors) {
		if (getService().getTeamByName(team.getTeamName()) != null) {
			errors.add("name", new SimpleError("Sorry, team names must be unique."));
		}
	}
	
	@HandlesEvent("save")
	public Resolution save() {
		Team updated = loadTeam();
		updated.setTeamName(team.getTeamName());
		log.debug("updated team:"+updated+" createdDate "+updated.getCreatedDate());
		getService().updateTeam(updated);
		return new RedirectResolution(ListTeamsActionBean.class);
	}
}
