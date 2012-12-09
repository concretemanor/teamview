package concretemanor.tools.teamview.dao;

import concretemanor.tools.teamview.builders.DateBuilder;
import concretemanor.tools.teamview.builders.PersonBuilder;
import concretemanor.tools.teamview.builders.PersonStatusBuilder;
import concretemanor.tools.teamview.builders.TeamBuilder;
import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.PersonStatus;
import concretemanor.tools.teamview.domain.Status;
import concretemanor.tools.teamview.domain.Team;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * User: shin4590
 * Date: 12/9/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-main-test.xml")
public class PersonStatusDaoIT {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private PersonStatusDao personStatusDao;

    @Transactional
    @Test
    public void shouldReturnOnePersonStatusInVacation() throws Exception {
        String aTeamName = "The A Team";
        Team ateam = TeamBuilder.newBuilder().withName(aTeamName).create();
        teamDao.save(ateam);

        String johnDoeName = "John Doe";
        Person johnDoe = PersonBuilder.newBuilder().withName(johnDoeName).withTeam(ateam).create();
        personDao.save(johnDoe);

        PersonStatus johnDoeStatus = PersonStatusBuilder.newBuilder().withPerson(johnDoe).withStatus(Status.VACATION).
                                    withDateOfStatus(new Date()).create();
        personStatusDao.save(johnDoeStatus);

        Calendar fiveDaysPrior = new GregorianCalendar();
        fiveDaysPrior.add(Calendar.DAY_OF_MONTH, -5);
        Calendar oneDayAfter = new GregorianCalendar();
        oneDayAfter.add(Calendar.DAY_OF_MONTH, 1);
        List<PersonStatus> personStatusList = personStatusDao.getByTeamAndDateRange(ateam, fiveDaysPrior.getTime(), oneDayAfter.getTime());
        assertNotNull("PersonStatusList should not be null", personStatusList);
        assertEquals("PersonStatusList size", 1, personStatusList.size());
        PersonStatus personStatus = personStatusList.get(0);
        assertNotNull("Person in PersonStatus should not be null", personStatus.getPerson());
        assertEquals("Person.name in PersonStatus", johnDoeName, personStatus.getPerson().getName());
        assertEquals("Person.team in PersonStatus", ateam, personStatus.getPerson().getTeam());
        assertEquals("Status in PersonStatus", Status.VACATION, personStatus.getStatus());
    }
}
