package concretemanor.tools.teamview.actions;

import java.util.Date;
import java.util.List;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.util.Log;
import concretemanor.tools.teamview.domain.Team;
import concretemanor.tools.teamview.actions.TeamUtil;

public class StatusContextActionBean extends PersonActionTeamBase {
	private static Log log = Log.getInstance(StatusContextActionBean.class);
	protected Integer teamId = null;

	public Integer getTeamId() {
		log.debug("getTeamId: teamId is null");
		if (teamId == null) {
			teamId = getService().getAllTeams().get(0).getId();
		}
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		log.debug("setTeam: teamId="+teamId);
		this.teamId = teamId;
	}

	public List<Team> getAllTeams() {
		List<Team> result = getService().getAllTeams();
		TeamUtil.sortTeamsByName(result);

		return result;
	}

	public Resolution refresh() {
		return new ForwardResolution("/main.jsp");
	}

	public Date getLastDate() {
		return dateFrom(6);
	}
}
