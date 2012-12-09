package concretemanor.tools.teamview.dao;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import concretemanor.tools.teamview.builders.TeamBuilder;
import concretemanor.tools.teamview.domain.Team;

/**
 * User: shin4590
 * Date: 12/8/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-main-test.xml")
public class TeamDaoIT {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private TeamDao teamDao;

    @Transactional
    @Test
    public void shouldReturnATeam() throws Exception {
        String teamName = "The A Team";
        Team team = TeamBuilder.newBuilder().withName(teamName).create();
        teamDao.save(team);
        Team teamFromDB = teamDao.getByName(teamName);
        assertEquals("Team Name", teamName, teamFromDB.getTeamName());
    }
}
