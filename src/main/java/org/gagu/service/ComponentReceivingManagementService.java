package org.gagu.service;

import org.gagu.entity.ComponentReceivingManagement;
import org.gagu.repository.ComponentReceivingManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentReceivingManagementService {
    private final ComponentReceivingManagementRepository componentReceivingManagementRepository;

    @Autowired
    public ComponentReceivingManagementService(ComponentReceivingManagementRepository componentReceivingManagementRepository){
        this.componentReceivingManagementRepository = componentReceivingManagementRepository;
    }
    public List<ComponentReceivingManagement> getAllComponentReceivingManagement(){
        return componentReceivingManagementRepository.findAll();
    }
}
