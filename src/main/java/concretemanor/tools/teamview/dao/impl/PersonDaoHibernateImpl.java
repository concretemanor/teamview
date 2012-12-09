package concretemanor.tools.teamview.dao.impl;

import concretemanor.tools.teamview.dao.PersonDao;
import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Team;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        final Query query = sessionFactory.getCurrentSession().getNamedQuery(Person.NAMED_QUERY_PERSONS_BY_TEAM);
        query.setParameter("team", team);
        return query.list();
    }

    @Override
    public Person save(Person person) throws HibernateException {
        sessionFactory.getCurrentSession().save(person);
        return person;
    }

}
