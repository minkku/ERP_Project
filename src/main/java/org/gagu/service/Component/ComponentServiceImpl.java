package org.gagu.service.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.component.ComponentResponse;
import org.gagu.entity.component.ComponentOrder;
import org.gagu.repository.component.ComponentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ComponentServiceImpl implements ComponentService{
    private final ComponentRepository componentRepository;


    @Override
    public Page<ComponentOrder> findAll(Pageable pageable) {
        return componentRepository.findAll(pageable);
    }
}
