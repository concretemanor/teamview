package concretemanor.tools.teamview.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import concretemanor.tools.teamview.domain.Person;

/**
 * Manager class that is used to access a "database" of people that is tracked in memory.
 */
public class PersonManager {
    /** Sequence counter for ID generation. */
    private static int idSequence = 0;

    /** Stores the list of people in the system. */
    private static Map<Integer,Person> people = new TreeMap<Integer,Person>();

    static {
        Person person = new Person() {{ setName("John"); }};
        saveOrUpdateInternal(person);

        person = new Person() {{ setName("Mary"); }};
        saveOrUpdateInternal(person);

        person = new Person() {{ setName("Shinta"); }};
        saveOrUpdateInternal(person);

        person = new Person() {{ setName("Sanjay"); }};
        saveOrUpdateInternal(person);

        person = new Person() {{ setName("Xiaoping"); }};
        saveOrUpdateInternal(person);
    }

    /** Returns the person with the specified ID, or null if no such person exists. */
    public Person getPerson(int id) {
        return people.get(id);
    }

    /** Gets a list of all the people in the system. */
    public List<Person> getAllPeople() {
        return Collections.unmodifiableList( new ArrayList<Person>(people.values()) );
    }

    /** Updates the person if the ID matches an existing person, otherwise saves a new person. */
    public void saveOrUpdate(Person person) {
        saveOrUpdateInternal(person);
    }

    private static void saveOrUpdateInternal(Person person) {
        if (person.getId() == null) {
            person.setId(idSequence++);
        }

        people.put(person.getId(), person);
    }
}
