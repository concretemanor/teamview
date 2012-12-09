package concretemanor.tools.teamview.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import concretemanor.tools.teamview.dao.PersonStatusDao;
import concretemanor.tools.teamview.domain.PersonStatus;
import concretemanor.tools.teamview.domain.Team;

/**
 * User: shin4590
 * Date: 12/8/12
 */
@Repository
public class PersonStatusDaoHibernateImpl implements PersonStatusDao {

    private SessionFactory sessionFactory;

    @Autowired
    public PersonStatusDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PersonStatus> getByDateRange(Date minDate, Date maxDate) {
        final Query query = sessionFactory.getCurrentSession().getNamedQuery(PersonStatus.NAMED_QUERY_PERSON_STATUS_BY_DATE_RANGE);
        query.setParameter("minDate", minDate);
        query.setParameter("maxDate", maxDate);
        return query.list();
    }

    @Override
    public List<PersonStatus> getByTeamAndDateRange(Team team, Date minDate, Date maxDate) {
        final Query query = sessionFactory.getCurrentSession().getNamedQuery(PersonStatus.NAMED_QUERY_PERSON_STATUS_BY_TEAM_AND_DATE_RANGE);
        query.setParameter("team", team);
        query.setParameter("minDate", minDate);
        query.setParameter("maxDate", maxDate);
        return query.list();
    }

    @Override
    public PersonStatus save(PersonStatus pstatus) throws HibernateException {
        sessionFactory.getCurrentSession().save(pstatus);
        return pstatus;
    }
}
