package concretemanor.tools.teamview.builders;

import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Team;

/**
 * User: shin4590
 * Date: 12/8/12
 */
public class PersonBuilder {

    private Person person;

    private PersonBuilder() {}

    public static PersonBuilder newBuilder() {
        PersonBuilder builder = new PersonBuilder();
        return builder;
    }

    public PersonBuilder withName(String name) {
        person = new Person();
        person.setName(name);
        return this;
    }

    public PersonBuilder withTeam(Team team) {
        if ( person != null ) {
            person.setTeam(team);
            return this;
        } else {
            throw new IllegalArgumentException("Must call withName() method first");
        }
    }

    public Person create() {
        return person;
    }
}
