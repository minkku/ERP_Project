package org.gagu.repository.businessPartner;

import org.gagu.dto.business.BusinessPartnerResponse;
import org.springframework.data.domain.Page;

public interface PartnerCustomRepository {
    Page<BusinessPartnerResponse> getPartnerList(int size, int page);
}
