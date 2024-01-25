package org.gagu.service.vender;

import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.entity.vender.Vender;
import org.springframework.data.domain.Page;

public interface VenderService {
    public Page<Vender> getVenderList(int size, int page);
}
