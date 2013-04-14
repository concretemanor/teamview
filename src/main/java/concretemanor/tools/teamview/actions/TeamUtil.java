package concretemanor.tools.teamview.actions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import concretemanor.tools.teamview.domain.Team;

public class TeamUtil {
    private static final Comparator<? super Team> BY_NAME  = new Comparator<Team>() {
	public int compare(Team t1, Team t2) {
	    return t1.getTeamName().compareTo(t2.getTeamName());
	}};

	public static void sortTeamsByName(List<Team> teams) {
		Collections.sort(teams,BY_NAME);
	}
}
