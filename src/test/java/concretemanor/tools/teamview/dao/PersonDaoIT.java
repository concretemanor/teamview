package concretemanor.tools.teamview.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import concretemanor.tools.teamview.builders.PersonBuilder;
import concretemanor.tools.teamview.builders.TeamBuilder;
import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Team;

/**
 * User: shin4590
 * Date: 12/8/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-main-test.xml")
public class PersonDaoIT {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private TeamDao teamDao;

    @Transactional
    @Test
    public void shouldReturnPerson() throws Exception {
        String aTeamName = "The A Team";
        Team ateam = TeamBuilder.newBuilder().withName(aTeamName).create();
        teamDao.save(ateam);

        String bTeamName = "The B Team";
        Team bteam = TeamBuilder.newBuilder().withName(bTeamName).create();
        teamDao.save(bteam);

        String johnDoeName = "John Doe";
        Person johnDoe = PersonBuilder.newBuilder().withName(johnDoeName).withTeam(ateam).create();
        personDao.save(johnDoe);

        String fooBarName = "Foo Bar";
        Person fooBar = PersonBuilder.newBuilder().withName(fooBarName).withTeam(ateam).create();
        personDao.save(fooBar);

        String somebodyName = "Somebody";
        Person somebody = PersonBuilder.newBuilder().withName(somebodyName).withTeam(bteam).create();
        personDao.save(somebody);

        List<Person> ateamPersons = personDao.getByTeam(ateam);
        assertNotNull("A Team Persons is not null", ateamPersons);
        assertEquals("A Team Persons size", 2, ateamPersons.size());

        List<Person> bteamPersons = personDao.getByTeam(bteam);
        assertNotNull("B Team Persons is not null", bteamPersons);
        assertEquals("B Team Persons size", 1, bteamPersons.size());
    }
}
