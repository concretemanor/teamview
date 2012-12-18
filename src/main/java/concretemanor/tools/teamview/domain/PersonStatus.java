package concretemanor.tools.teamview.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Type;

/**
 * User: shin4590
 * Date: 12/8/12
 */
@Entity
@Table(name = "`tmv_personstatus`")
@NamedQueries(value = {
        @NamedQuery(name=PersonStatus.NAMED_QUERY_PERSON_STATUS_BY_DATE_RANGE,
                query="from PersonStatus where dateOfStatus>=:minDate and dateOfStatus<=:maxDate"),
        @NamedQuery(name=PersonStatus.NAMED_QUERY_PERSON_STATUS_BY_TEAM_AND_DATE_RANGE,
                query="from PersonStatus where person.team=:team and dateOfStatus>=:minDate and dateOfStatus<=:maxDate")
})
public class PersonStatus implements Serializable {

    public final static String NAMED_QUERY_PERSON_STATUS_BY_DATE_RANGE = "query.personStatus.by.dateRange";

    public final static String NAMED_QUERY_PERSON_STATUS_BY_TEAM_AND_DATE_RANGE = "query.personStatus.by.team.and.dateRange";

    private Integer id;
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "GENERATOR")
    @SequenceGenerator(name = "GENERATOR", sequenceName = "`tmv_personstatus_id_seq`", allocationSize = 1)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    private Person person;
    @OneToOne
    @JoinColumn(name = "`tmv_personid`", referencedColumnName = "`id`")
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    private Date dateOfStatus;
    @Column(name = "`dateofstatus`", insertable = true, updatable = true, columnDefinition = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateOfStatus() {
        return dateOfStatus;
    }
    public void setDateOfStatus(Date date) {
        this.dateOfStatus = date;
    }

    private Status status;
    @Type(type = "concretemanor.tools.teamview.hibernate.StatusUserType")
    @Column(name = "`status`")
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
