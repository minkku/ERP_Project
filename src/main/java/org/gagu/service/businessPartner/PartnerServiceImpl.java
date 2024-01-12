package org.gagu.service.businessPartner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.business.RegisterResponse;
import org.gagu.entity.businessPartner.BusinessPartner;
import org.gagu.repository.businessPartner.PartnerRepository;
import org.gagu.repository.member.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {
    private final PartnerRepository partnerRepository;
    private final MemberRepository memberRepository;

    @Override
    public void register(RegisterResponse response) {
        log.info("--------------- ServiceImpl Register --------------");

        // RegisterResponse를 BusinessPartner로 변환
        BusinessPartner businessPartner = mapToEntity(response);

        // BusinessPartner 저장
        partnerRepository.save(businessPartner);
    }

    private BusinessPartner mapToEntity(RegisterResponse response) {
        return BusinessPartner.builder()
                .bpName(response.getBpName())
                .companyNumber(response.getCompanyNumber())
                .phone(response.getPhone())
                .fax(response.getFax())
                .address(response.getAddress())
                .headName(response.getHeadName())
                .type(response.getType())
                .note(response.getNote())
                .bigType(response.getBigType())
                .smallType(response.getSmallType())
                .build();
    }
}
