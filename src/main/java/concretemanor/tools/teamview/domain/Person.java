package concretemanor.tools.teamview.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "`tmv_person`")
@NamedQueries(value = {
        @NamedQuery(name=Person.NAMED_QUERY_PERSONS_BY_TEAM_ID, query="select distinct p from Person p join p.teams t where t.id = :teamId"),
        @NamedQuery(name=Person.NAMED_QUERY_PERSON_BY_NAME, query="select p from Person p where p.name = :name")
})
public class Person implements Comparable<Person> {

    public final static String NAMED_QUERY_PERSONS_BY_TEAM_ID = "query.persons.by.team.id";
    public final static String NAMED_QUERY_PERSON_BY_NAME = "query.person.by.name";

	private Integer id;
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "GENERATOR")
    @SequenceGenerator(name = "GENERATOR", sequenceName = "`tmv_person_id_seq`", allocationSize = 1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    private Date createdDate;
    @Column(name = "`createddate`", insertable = true, updatable = false, columnDefinition = "timestamp default current_timestamp")
    @Generated(value = GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

	private String name;
    @Column(name = "`name`", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    private List<Team> teams = new ArrayList<Team>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "`tmv_xref_person_team`", joinColumns = {
            @JoinColumn(name = "tmv_personid", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "tmv_teamid",
                    nullable = false, updatable = false) })
    public List<Team> getTeams() {
        return Collections.unmodifiableList(teams);
    }
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void removeTeam(Team team) {
        teams.remove(team);
    }

	public int compareTo(Person o) {
		int result = id - o.id;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		boolean result;
		if (! (o instanceof Person)) {
			result = false;
		}
		else {
			Person other = (Person)o;
			result = other.id == id;
		}

		return result;
	}
	
	@Override
	public String toString() {
		String result = String.valueOf("id="+id);
		return result;
	}
}
