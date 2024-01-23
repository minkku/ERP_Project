package org.gagu.service.businessPartner;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.business.BusinessPartnerDetailResponse;
import org.gagu.dto.business.RegisterResponse;
import org.gagu.dto.business.UpdateRequest;
import org.gagu.entity.businessPartner.BusinessPartner;
import org.gagu.repository.businessPartner.PartnerRepository;
import org.gagu.repository.member.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {
    private final PartnerRepository partnerRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public BusinessPartnerDetailResponse getDetail(int partnerId) {
        Optional<BusinessPartner> b = partnerRepository.findById(partnerId);
        BusinessPartner businessPartner = b.get();

        BusinessPartnerDetailResponse businessPartnerDetailResponse = BusinessPartnerDetailResponse.builder()
                .partnerId(businessPartner.getPartnerId())
                .bpName(businessPartner.getBpName())
                .companyNumber(businessPartner.getCompanyNumber())
                .phone(businessPartner.getPhone())
                .fax(businessPartner.getFax())
                .address(businessPartner.getAddress())
                .headName(businessPartner.getHeadName())
                .type(businessPartner.getType())
                .note(businessPartner.getNote())
                .bigType(businessPartner.getBigType())
                .smallType(businessPartner.getSmallType())
                .build();
        return businessPartnerDetailResponse;
    }

    @Override
    public BusinessPartner registerResponse(RegisterResponse response) {
       BusinessPartner businessPartner = BusinessPartner.builder()
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
        return partnerRepository.save(businessPartner);
    }

    @Override
    @Transactional
    public void updatePartner(int partnerId, UpdateRequest request) {
        partnerRepository.updatePartner(partnerId, request);
    }
}
