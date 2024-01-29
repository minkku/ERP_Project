package org.gagu.controller;

import lombok.extern.log4j.Log4j2;
import org.gagu.dto.ProductOrderCustomDTO;
import org.gagu.service.ProductPurchaseOrderCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class ProductPurchaseOrderCreationController {
    @Autowired
    ProductPurchaseOrderCreationService productPurchaseOrderCreationService;

    @GetMapping("/ProductPurchaseOrderCreation")
    public String getProductPurchaseOrderCreation(@RequestParam ProductOrderCustomDTO productOrderCustomDTO, Model model) {
        log.info(productOrderCustomDTO);
        String productOrderNumber = productPurchaseOrderCreationService.newPOCode();
        log.info("ProductOrderNumber ==============" + productOrderNumber);
        model.addAttribute("ProductOrderNumber", productOrderNumber);
        return "ProductPurchaseOrderCreation";
    }
}
