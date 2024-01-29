package org.gagu.controller;

import org.gagu.entity.ProductionOrder;
import org.gagu.service.ProductionOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductionOrderController {

    @Autowired
    private ProductionOrderService productionOrderService;

    @GetMapping("/production-orders")
    public String getAllProductionOrders(Model model) {
        List<ProductionOrder> productionOrders = productionOrderService.getAllProductionOrders();
        model.addAttribute("productionOrders", productionOrders);
        return "productionOrdersList";
    }


}
