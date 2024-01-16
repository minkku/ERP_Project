package org.gagu.controller;

import lombok.extern.log4j.Log4j2;
import org.gagu.entity.ComponentReceivingManagement;
import org.gagu.service.ComponentReceivingManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Log4j2
public class ComponentReceivingManagementController {
    private final ComponentReceivingManagementService componentReceivingManagementService;

    @Autowired
    public ComponentReceivingManagementController(ComponentReceivingManagementService componentReceivingManagementService){
        this.componentReceivingManagementService = componentReceivingManagementService;
    }

    @GetMapping("/ComponentReceivingManagement")
    public ModelAndView getComponentReceivingManagementList() {
    //public List<component-quotation> getComponentReceivingManagementList() {

    ModelAndView modelAndView = new ModelAndView();

    // component-quotationService에서 데이터를 받아옴
    List<ComponentReceivingManagement> componentReceivingManagements = componentReceivingManagementService.getAllComponentReceivingManagement();

    // 받아온 데이터를 뷰로 전달
        modelAndView.addObject("componentReceivingManagements", componentReceivingManagements);

    // 이동할 뷰 페이지 설정
        modelAndView.setViewName("components-receiving-management");

        return modelAndView;
    }
}
