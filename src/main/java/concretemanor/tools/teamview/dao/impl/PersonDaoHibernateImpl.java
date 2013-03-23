package concretemanor.tools.teamview.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import concretemanor.tools.teamview.dao.PersonDao;
import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Team;

/**
 * User: shin4590
 * Date: 12/8/12
 */
@Repository
public class PersonDaoHibernateImpl implements PersonDao {

    private SessionFactory sessionFactory;

    @Autowired
    public PersonDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Person get(Integer id) {
        final Object obj = sessionFactory.getCurrentSession().get(Person.class, id);
        return (Person) obj;
    }

    public List<Person> getByTeam(Team team) {
        if ( team == null ) {
            throw new IllegalArgumentException("getByTeam() must be called with a non-null Team object");
        }
        final Query query = sessionFactory.getCurrentSession().getNamedQuery(Person.NAMED_QUERY_PERSONS_BY_TEAM_ID);
        query.setParameter("teamId", team.getId());
        return query.list();
    }

    @Override
    public Person save(Person person) throws HibernateException {
        sessionFactory.getCurrentSession().save(person);
        return person;
    }

}
