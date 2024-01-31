package org.gagu.entity.notice;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gagu.entity.member.Member;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Getter
@DynamicUpdate
@Table(name = "notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id", nullable = false)
    private int noticeId;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member memberId;

    @Column(name = "notice_title")
    private String title;

    @Column(name = "notice_content")
    private String content;

    @Column(name = "notice_regdate")
    private Timestamp regDate;

    @Column(name = "notice_updatedate")
    private Timestamp updateDate;

    @Builder
    public Notice(int noticeId,
                  Member memberId,
                  String title,
                  String content,
                  Timestamp regDate,
                  Timestamp updateDate) {
        this.noticeId = noticeId;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.updateDate = updateDate;
    }
}
