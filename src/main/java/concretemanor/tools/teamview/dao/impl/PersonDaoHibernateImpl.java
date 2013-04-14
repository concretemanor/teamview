package concretemanor.tools.teamview.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
    
    public Person getByName(String name) {
    	final Query query = sessionFactory.getCurrentSession().getNamedQuery(Person.NAMED_QUERY_PERSON_BY_NAME);
    	query.setParameter("name",name);
    	List<Person> list = query.list();
    	Person result = list.size() == 0 ? null : list.get(0);
    	return result;
    }
 
    public List<Person> getByTeam(Team team) {
        if ( team == null ) {
            throw new IllegalArgumentException("getByTeam() must be called with a non-null Team object");
        }
        final Query query = sessionFactory.getCurrentSession().getNamedQuery(Person.NAMED_QUERY_PERSONS_BY_TEAM_ID);
        query.setParameter("teamId", team.getId());
        return query.list();
    }
    
    private static final String PERSONS_BY_NOT_TEAM_ID = 
    		"SELECT * "+
    		"FROM tmv_person p "+
    		"WHERE p.id NOT IN ( "+
    		"   SELECT tmv_personid FROM tmv_xref_person_team WHERE tmv_teamid = :teamId) "+
    		"AND p.name LIKE :prefix";
    
    public List<Person> getByNotTeam(Team team,String namePrefix,int maxRows) {
        if ( team == null ) {
            throw new IllegalArgumentException("getByNotTeam() must be called with a non-null Team object");
        }
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(PERSONS_BY_NOT_TEAM_ID).addEntity(Person.class);
        query.setParameter("teamId", team.getId());
        query.setParameter("prefix", namePrefix + "%");
        query.setMaxResults(maxRows);
        	
        return query.list();
   }

    @Override
    public Person save(Person person) throws HibernateException {
        sessionFactory.getCurrentSession().saveOrUpdate(person);
        return person;
    }

}
