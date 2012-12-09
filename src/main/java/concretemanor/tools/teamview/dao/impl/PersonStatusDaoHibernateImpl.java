package concretemanor.tools.teamview.dao.impl;

import concretemanor.tools.teamview.dao.PersonStatusDao;
import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.PersonStatus;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shin4590
 * Date: 12/8/12
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PersonStatusDaoHibernateImpl implements PersonStatusDao {

    private SessionFactory sessionFactory;

    @Autowired
    public PersonStatusDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PersonStatusDao> getByDateRange(Date minDate, Date maxDate) {
        final Query query = sessionFactory.getCurrentSession().getNamedQuery(PersonStatus.NAMED_QUERY_PERSON_STATUS_BY_DATE_RANGE);
        query.setParameter("minDate", minDate);
        query.setParameter("maxDate", maxDate);
        return query.list();
    }
}
