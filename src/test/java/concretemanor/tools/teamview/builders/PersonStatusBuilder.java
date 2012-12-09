package concretemanor.tools.teamview.builders;

import java.util.Date;

import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.PersonStatus;
import concretemanor.tools.teamview.domain.Status;

/**
 * User: shin4590
 * Date: 12/9/12
 */
public class PersonStatusBuilder {

    private PersonStatus personStatus;

    private PersonStatusBuilder() {}

    public static PersonStatusBuilder newBuilder() {
        PersonStatusBuilder builder = new PersonStatusBuilder();
        builder.personStatus = new PersonStatus();
        return builder;
    }

    public PersonStatusBuilder withPerson(Person person) {
        personStatus.setPerson(person);
        return this;
    }

    public PersonStatusBuilder withStatus(Status status) {
        personStatus.setStatus(status);
        return this;
    }

    public PersonStatusBuilder withDateOfStatus(Date dateOfStatus) {
        personStatus.setDateOfStatus(dateOfStatus);
        return this;
    }

    public PersonStatus create() {
        return personStatus;
    }
}
