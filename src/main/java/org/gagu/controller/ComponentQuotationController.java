package org.gagu.controller;

import lombok.extern.log4j.Log4j2;
import org.gagu.entity.ComponentQuotation;
import org.gagu.service.ComponentQuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Log4j2
public class ComponentQuotationController {
    private final ComponentQuotationService componentQuotationService;

    @Autowired
    public ComponentQuotationController(ComponentQuotationService componentQuotationService){
        this.componentQuotationService = componentQuotationService;
    }

    @GetMapping("/ComponentQuotation")
    public ModelAndView getComponentQuotationList() {
    //public List<component-quotation> getComponentQuotationList() {

    ModelAndView modelAndView = new ModelAndView();

    // component-quotationService에서 데이터를 받아옴
    List<ComponentQuotation> componentQuotations = componentQuotationService.getAllComponentQuotation();

    // 받아온 데이터를 뷰로 전달
        modelAndView.addObject("componentQuotations", componentQuotations);

    // 이동할 뷰 페이지 설정
        modelAndView.setViewName("components-quotations");

        return modelAndView;
    }
}
