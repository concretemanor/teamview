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
     * Gets the Person object by its name
     * @param name person's name
     * @return Person object or null if no such person
     */
    public Person getByName(String name);

    /**
     * Gets a list of Person objects that belong to a specific Team
     * @param team Team whose Person members are to fetched
     * @return List
     */
    public List<Person> getByTeam(Team team);
    
    /**
     * Gets a list of Person objects that do not belong to the specific Team
     * and whose name begins with the specific prefix.
     * @param team Team that the Person members do not belong to
     * @param namePrefix All returned Person name begin with this prefix
     * @return List (possibly empty)
     */
    public List<Person> getByNotTeam(Team team,String namePrefix,int maxRows);

    /**
     * Saves the Team object
     * @param team
     * @return
     */
    public Person save(Person team);
}
