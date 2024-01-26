package org.gagu.repository.member;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.MemberCustomDTO;
import org.gagu.entity.QProductOrder;
import org.gagu.entity.member.Member;
import org.gagu.entity.member.QMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
public class MemberInfoRepositoryImpl implements MemberInfoRepository{
    @Autowired
    private final JPAQueryFactory jpaQueryFactory;

    public MemberInfoRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public MemberCustomDTO findMemberByMemberId(Integer productOrderId, Integer memberId) {
        QProductOrder qProductOrder = QProductOrder.productOrder;
        QMember qMember = QMember.member;

        MemberCustomDTO result = jpaQueryFactory
                .select(Projections.bean(MemberCustomDTO.class,
                        qProductOrder.productOrderId,
                        qMember.memberId,
                        qMember.memberName,
                        qMember.userId,
                        qMember.password,
                        qMember.department,
                        qMember.position,
                        qMember.regdate))
                .from(qMember)
                .join(qProductOrder).on(qMember.memberId.eq(qProductOrder.memberId))
                .where(new BooleanBuilder()
                        .and(qProductOrder.productOrderId.eq(productOrderId))
                        .and(qMember.memberId.eq(memberId)))
                .fetchOne();
        log.info("MemberCustomDTO: {}", result);
        return result;
    }
}
