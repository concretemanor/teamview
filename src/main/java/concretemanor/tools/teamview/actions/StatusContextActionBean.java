package concretemanor.tools.teamview.actions;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.util.Log;
import concretemanor.tools.teamview.domain.Team;

public class StatusContextActionBean extends ActionBeanBase {
    private static Log log = Log.getInstance(StatusContextActionBean.class);

    protected Integer teamId = null;

    private static final Comparator BY_NAME  = new Comparator<Team>() {
	public int compare(Team t1, Team t2) {
	    return t1.getTeamName().compareTo(t2.getTeamName());
	}};

    public StatusContextActionBean() {
	super();
    }

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
	Collections.sort(result,BY_NAME);
		
	return result;
    }

    public Resolution refresh() {
	return new ForwardResolution("/main.jsp");
    }

    public Date getLastDate() {
	return dateFrom(6);
    }
}
