package concretemanor.tools.teamview.dao;

import java.util.List;

import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Team;

/**
 * User: shin4590
 * Date: 12/8/12
 */
public interface PersonDao {

    /**
     * Gets the Person object by its ID
     * @param id the unique ID of the Person object
     * @return Person
     */
    public Person get(Integer id);

    /**
     * Gets a list of Person objects that belong to a specific Team
     * @param team Team whose Person members are to fetched
     * @return List
     */
    public List<Person> getByTeam(Team team);

    /**
     * Saves the Team object
     * @param team
     * @return
     */
    public Person save(Person team);
}
