package concretemanor.tools.teamview.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * User: shin4590
 * Date: 12/8/12
 */
@Entity
@Table(name = "`TMV_PersonStatus`")
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
    @Column(name = "`ID`")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATOR")
    @SequenceGenerator(name = "GENERATOR", sequenceName = "`TMV_PersonStatus_ID_seq`", allocationSize = 1)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    private Person person;
    @OneToOne
    @JoinColumn(name = "`TMV_PersonID`")
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    private Date dateOfStatus;
    @Column(name = "`DateOfStatus`", insertable = true, updatable = true, columnDefinition = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateOfStatus() {
        return dateOfStatus;
    }
    public void setDateOfStatus(Date date) {
        this.dateOfStatus = date;
    }

    private Status status;
    @Type(type = "concretemanor.tools.teamview.domain.Status")
    @Column(name = "`Status`")
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
