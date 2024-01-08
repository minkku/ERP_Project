package org.gagu.controller;

import lombok.extern.log4j.Log4j2;
import org.gagu.entity.ComponentOrder;
import org.gagu.service.ComponentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class ComponentOrderController {
    private final ComponentOrderService componentOrderService;

    @Autowired
    public ComponentOrderController(ComponentOrderService componentOrderService){
        this.componentOrderService = componentOrderService;
    }

    @GetMapping("/ComponentPurchase")
    public List<ComponentOrder> GetComponentOrderList() {
        return componentOrderService.getAllComponentOrderVO();
    }
}
