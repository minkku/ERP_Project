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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Log4j2
public class ComponentOrderController {
    private final ComponentOrderService componentOrderService;

    @Autowired
    public ComponentOrderController(ComponentOrderService componentOrderService){
        this.componentOrderService = componentOrderService;
    }

    @GetMapping("/ComponentOrder")
    public ModelAndView GetComponentOrderList() {
    //public List<ComponentOrder> GetComponentOrderList() {

    ModelAndView modelAndView = new ModelAndView();

    // componentOrderService에서 데이터를 받아옴
    List<ComponentOrder> componentOrders = componentOrderService.getAllComponentOrder();

    // 받아온 데이터를 뷰로 전달
        modelAndView.addObject("componentOrders", componentOrders);

    // 이동할 뷰 페이지 설정
        modelAndView.setViewName("components-Orders");

        return modelAndView;
    }
}
