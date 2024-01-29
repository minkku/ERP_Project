package org.gagu.service.impl;

import org.gagu.entity.ProductionOrder;
import org.gagu.repository.ProductionOrderRepository;
import org.gagu.service.ProductionOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionOrderServiceImpl implements ProductionOrderService {

    @Autowired
    private ProductionOrderRepository productionOrderRepository;

    @Override
    public List<ProductionOrder> getAllProductionOrders() {
        return productionOrderRepository.findAll();
    }

    // 다른 CRUD 작업도 필요에 따라 추가하세요
}
