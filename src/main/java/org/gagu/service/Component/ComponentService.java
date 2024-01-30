package org.gagu.service.Component;

import org.gagu.dto.component.ComponentResponse;
import org.gagu.entity.component.ComponentOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ComponentService {
    public Page<ComponentOrder> findAll(Pageable pageable);
}
