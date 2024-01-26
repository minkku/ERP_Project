package org.gagu.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gagu.dto.MemberCustomDTO;
import org.gagu.repository.member.MemberInfoRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductSalesHistoryService {
    private final MemberInfoRepository memberInfoRepository;

    public MemberCustomDTO getMemberCustomDTO(Integer productOrderId, Integer memberId) {
        return memberInfoRepository.findMemberByMemberId(productOrderId, memberId);
    }
}
