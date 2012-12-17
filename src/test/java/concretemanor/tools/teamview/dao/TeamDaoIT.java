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

import java.util.List;

import static org.junit.Assert.*;

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

    @Transactional
    @Test
    public void shouldReturnAllTeam() throws Exception {
        String ateamName = "The A Team";
        Team ateam = TeamBuilder.newBuilder().withName(ateamName).create();
        teamDao.save(ateam);

        String bteamName = "The B Team";
        Team bteam = TeamBuilder.newBuilder().withName(bteamName).create();
        teamDao.save(bteam);

        List<Team> allTeams = teamDao.getAll();
        assertNotNull("allTeams must not be null", allTeams);
        assertEquals("allTeams size", 2, allTeams.size());
    }
}
