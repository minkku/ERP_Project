package org.gagu.service.businessPartner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.business.RegisterResponse;
import org.gagu.repository.businessPartner.PartnerRepository;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {
    private final PartnerRepository partnerRepository;

    @Override
    public Integer register(RegisterResponse response) {
        log.info("--------------- ServiceImpl Register --------------");
        
    }
}
