package concretemanor.tools.teamview.dao.impl;

import concretemanor.tools.teamview.dao.TeamDao;
import concretemanor.tools.teamview.domain.Team;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: shin4590
 * Date: 12/8/12
 */
@Repository
public class TeamDaoHibernateImpl implements TeamDao {

    private SessionFactory sessionFactory;

    @Autowired
    public TeamDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Team getByName(String name) throws HibernateException {
        final Query query = sessionFactory.getCurrentSession().getNamedQuery(Team.NAMED_QUERY_TEAM_BY_NAME);
        query.setParameter("teamName", name);
        return (Team) query.uniqueResult();

    }

    @Override
    public List<Team> getAll() throws HibernateException {
        final Query query = sessionFactory.getCurrentSession().getNamedQuery(Team.NAMED_QUERY_ALL_TEAMS);
        return query.list();
    }

    @Override
    public Team save(Team team) throws HibernateException {
        sessionFactory.getCurrentSession().save(team);
        return team;
    }
}
