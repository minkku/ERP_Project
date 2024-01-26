package org.gagu.service.vender;

import org.gagu.dto.vender.RegisterVenderResponse;
import org.gagu.dto.vender.UpdateVender;
import org.gagu.dto.vender.VenderResponse;
import org.gagu.entity.vender.Vender;
import org.springframework.data.domain.Page;

public interface VenderService {
    public Page<VenderResponse> getVenderList(int size, int page);

    Vender registerVender(RegisterVenderResponse registerVenderResponse);

    public Vender getVender(int venderId);

    void updateVender(int venderId, UpdateVender request);
}