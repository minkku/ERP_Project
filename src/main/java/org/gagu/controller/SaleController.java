package org.gagu.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.ProductOrderListDTO;
import org.gagu.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
public class SaleController {
    private final ProductOrderService productOrderService;

    @Autowired
    public SaleController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping("/ProductOrderStatus")
    public String showOrderStatus(Model model) {
        List<ProductOrderListDTO> productOrderList = productOrderService.getProductOrderList();
        model.addAttribute("ProductOrderList", productOrderList);

        // Return the Thymeleaf template name (without ".html" extension)
        return "ProductOrderStatus";
    }
}
