package concretemanor.tools.teamview.actions;

import java.util.Date;
import java.util.List;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.util.Log;
import concretemanor.tools.teamview.domain.Team;

public class StatusContextActionBean extends ActionBeanBase {
	private static Log loggie = Log.getInstance(StatusContextActionBean.class);

	protected Integer teamId = null;

	public StatusContextActionBean() {
		super();
	}

	public Integer getTeamId() {
	    if (teamId == null) {
			teamId = getService().getAllTeams().get(0).getId();
		}
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		loggie.debug("setTeam: teamId="+teamId);
		this.teamId = teamId;
	}

	public List<Team> getAllTeams() {
		List<Team> result = getService().getAllTeams();
		return result;
	}

	public Resolution refresh() {
		return new ForwardResolution("/main.jsp");
	}

	public Date getLastDate() {
		return dateFrom(6);
	}
}