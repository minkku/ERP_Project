package org.gagu.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_userid")
    private String userId;

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_department")
    private String department;

    @Column(name = "member_position")
    private String position;

    @Column(name = "member_regdate")
    private LocalDateTime regdate;

    @Builder
    public Member(Integer memberId, String memberName, String userId, String password, String department, String position, LocalDateTime regdate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.userId = userId;
        this.password = password;
        this.department = department;
        this.position = position;
        this.regdate = regdate;
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void addMemberRole(MemberRole memberRole) {
        roleSet.add(memberRole);
    }
}
