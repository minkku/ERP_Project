package org.gagu.service.businessPartner;

import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.entity.businessPartner.BusinessPartner;
import org.springframework.data.domain.Page;


public interface BusinessPartnerService {
    public Page<BusinessPartnerResponse> getPartnerList(int size, int page);
}
