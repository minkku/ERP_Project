package org.gagu.service.businessPartner;

import lombok.RequiredArgsConstructor;
import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.repository.businessPartner.PartnerRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessPartnerServiceImpl implements BusinessPartnerService {
    private final PartnerRepository partnerRepository;

    @Override
    public Page<BusinessPartnerResponse> getPartnerList(int size, int page) {
        return partnerRepository.getPartnerList(size, page);
    }
}
