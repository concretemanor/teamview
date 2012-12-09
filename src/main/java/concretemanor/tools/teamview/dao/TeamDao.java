package concretemanor.tools.teamview.dao;

import concretemanor.tools.teamview.domain.Team;

/**
 * User: shin4590
 * Date: 12/8/12
 */
public interface TeamDao {

    /**
     * Gets the Team object by its name
     * @param name the name of the Team object to fetch
     * @return Team
     */
    public Team getByName(String name);

    /**
     * Saves the Team object
     * @param team
     * @return
     */
    public Team save(Team team);
}
