package org.gagu.service;

import lombok.Data;
import org.gagu.entity.ComponentOrder;
import org.gagu.repository.ComponentOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentOrderService {
    private final ComponentOrderRepository componentOrderRepository;

    @Autowired
    public ComponentOrderService(ComponentOrderRepository componentOrderRepository){
        this.componentOrderRepository = componentOrderRepository;
    }
    public List<ComponentOrder> getAllComponentOrder(){
        return componentOrderRepository.findAll();
    }
}
