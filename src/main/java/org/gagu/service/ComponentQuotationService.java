package org.gagu.service;

import org.gagu.entity.ComponentQuotation;
import org.gagu.repository.ComponentQuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentQuotationService {
    private final ComponentQuotationRepository componentQuotationRepository;

    @Autowired
    public ComponentQuotationService(ComponentQuotationRepository componentQuotationRepository){
        this.componentQuotationRepository = componentQuotationRepository;
    }
    public List<ComponentQuotation> getAllComponentQuotation(){
        return componentQuotationRepository.findAll();
    }
}
