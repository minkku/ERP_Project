package org.gagu.service.businessPartner;

import org.gagu.dto.business.RegisterResponse;
import org.gagu.entity.businessPartner.BusinessPartner;
import org.gagu.repository.businessPartner.PartnerRepository;

import java.util.List;
import java.util.Optional;

public interface PartnerService {
    BusinessPartner registerResponse(RegisterResponse registerResponse);

    // Update BusinessPartner
    public void updatePartnerList(int partnerId);
}
