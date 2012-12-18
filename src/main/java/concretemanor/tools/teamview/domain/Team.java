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
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

/**
 * Created with IntelliJ IDEA.
 * User: shin4590
 * Date: 11/16/12
 */
@Entity
@Table(name = "`tmv_team`")
@NamedQueries(value = {
    @NamedQuery(name=Team.NAMED_QUERY_TEAM_BY_NAME, query="from Team where teamName=:teamName"),
    @NamedQuery(name=Team.NAMED_QUERY_ALL_TEAMS, query="from Team"),
    @NamedQuery(name=Team.NAMED_QUERY_TEAM_BY_ID, query="from Team where id=:id")
})
public class Team implements Serializable {

    public final static String NAMED_QUERY_TEAM_BY_NAME = "query.team.by.name";
    public final static String NAMED_QUERY_TEAM_BY_ID = "query.team.by.id";
    public final static String NAMED_QUERY_ALL_TEAMS = "query.all.teams";

    private Integer id;

    private String teamName;

    private Date createdDate;

    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "teamid")
    @SequenceGenerator(name = "teamid", sequenceName = "`tmv_team_id_seq`", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`createddate`", insertable = true, updatable = false, columnDefinition = "timestamp default current_timestamp")
    @Generated(value = GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "`teamname`", nullable = false, unique = true)
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    public String toString() {
    	return "id "+id+" teamName "+teamName;
    }

}
