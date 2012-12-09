package concretemanor.tools.teamview.builders;

import concretemanor.tools.teamview.domain.Team;

/**
 * Created with IntelliJ IDEA.
 * User: shin4590
 * Date: 12/8/12
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeamBuilder {

    private Team team;

    private TeamBuilder() {}

    public static TeamBuilder newBuilder() {
        TeamBuilder builder = new TeamBuilder();
        builder.team = new Team();
        return builder;
    }

    public TeamBuilder withName(String name) {
        team.setTeamName(name);
        return this;
    }

    public Team create() {
        return team;
    }
}
