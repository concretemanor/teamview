package concretemanor.tools.teamview.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "`TMV_Person`")
@NamedQueries(value = {
        @NamedQuery(name=Person.NAMED_QUERY_PERSONS_BY_TEAM, query="from Person where team=:team")
})
public class Person implements Comparable<Person> {

    public final static String NAMED_QUERY_PERSONS_BY_TEAM = "query.persons.by.team";

	private Integer id;
    @Id
    @Column(name = "`ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "GENERATOR")
    @SequenceGenerator(name = "GENERATOR", sequenceName = "`TMV_Person_ID_seq`", allocationSize = 1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    private Date createdDate;
    @Column(name = "`CreatedDate`", insertable = true, updatable = false, columnDefinition = "timestamp default current_timestamp")
    @Generated(value = GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

	private String name;
    @Column(name = "`Name`", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

//	private Status[] status;
//	public Status[] getStatus() {
//		return status;
//	}
//	public void setStatus(Status[] status) {
//		this.status = status;
//	}

    private Team team;
    @ManyToOne
    @JoinColumn(name = "`TMV_TeamID`")
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
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
