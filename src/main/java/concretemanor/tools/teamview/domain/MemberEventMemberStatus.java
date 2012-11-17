package concretemanor.tools.teamview.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shin4590
 * Date: 11/16/12
 */
@Entity
@Table(name = "`TMV_MemberEventMemberStatus`")
public class MemberEventMemberStatus implements Serializable {

    private Long id;

    private Member member;

    private Event event;

    private MemberStatus memberStatus;

    @Column(name = "`ID`")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATOR")
    @SequenceGenerator(name = "GENERATOR", sequenceName = "`TMV_Member_ID_seq`", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "`TMV_EventID`")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @OneToOne
    @JoinColumn(name = "`TMV_MemberID`")
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Type(type = "concretemanor.tools.teamview.domain.MemberStatus")
    @Column(name = "`MemberStatus`")
    public MemberStatus getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }
}
