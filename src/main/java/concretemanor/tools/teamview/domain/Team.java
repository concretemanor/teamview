package concretemanor.tools.teamview.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.NaturalId;

/**
 * Created with IntelliJ IDEA.
 * User: shin4590
 * Date: 11/16/12
 */
@Entity
@Table(name = "`TMV_Team`")
@NamedQueries(value = {
    @NamedQuery(name=Team.NAMED_QUERY_TEAM_BY_NAME, query="from Team where teamName=:teamName"),
    @NamedQuery(name=Team.NAMED_QUERY_ALL_TEAMS, query="from Team")
})
public class Team implements Serializable {

    public final static String NAMED_QUERY_TEAM_BY_NAME = "query.team.by.name";

    public final static String NAMED_QUERY_ALL_TEAMS = "query.all.teams";

    private Integer id;

    private String teamName;

    private Date createdDate;

    @Column(name = "`ID`")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GENERATOR")
    @SequenceGenerator(name = "GENERATOR", sequenceName = "`TMV_Team_ID_seq`", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`CreatedDate`", insertable = true, updatable = false, columnDefinition = "timestamp default current_timestamp")
    @Generated(value = GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "`TeamName`", nullable = false, unique = true)
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

}
