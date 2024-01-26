package org.gagu.repository.member;

import org.gagu.dto.MemberCustomDTO;
import org.gagu.entity.member.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInfoRepository {
    public MemberCustomDTO findMemberByMemberId(Integer productOrderId, Integer memberId);
}
