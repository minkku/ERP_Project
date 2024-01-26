package org.gagu.controller;

import lombok.extern.log4j.Log4j2;
import org.gagu.dto.ProductOrderInfoDataDTO;
import org.gagu.dto.ProductOrderListDTO;
import org.gagu.service.ProductOrderCheckoutConfirmationService;
import org.gagu.service.ProductOrderInfoService;
import org.gagu.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j2
public class ProductOrderListController {
    private final ProductOrderService productOrderService;
    private final ProductOrderInfoService productOrderInfoService;
    private final ProductOrderCheckoutConfirmationService productOrderCheckoutConfirmationService;

    @Autowired
    public ProductOrderListController(ProductOrderService productOrderService, ProductOrderInfoService productOrderDetailService, ProductOrderCheckoutConfirmationService productOrderCheckoutConfirmationService) {
        this.productOrderService = productOrderService;
        this.productOrderInfoService = productOrderDetailService;
        this.productOrderCheckoutConfirmationService = productOrderCheckoutConfirmationService;
    }

    @GetMapping("/ProductOrderList")
    public String getOrderList(@RequestParam(defaultValue = "0", required = false) int page,
                               @RequestParam(defaultValue = "10", required = false) int pageSize,
                               Model model) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<ProductOrderListDTO> productOrderList = productOrderService.getProductOrderAllList(pageable);
        model.addAttribute("ProductOrderList", productOrderList);

        // Calculate total pages dynamically based on total item count
        long totalItems = productOrderService.getProductOrderAllListCount(); // You need to implement this method
        int totalPages = (int) Math.max(1, Math.ceil((double) totalItems / pageSize));

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);

        return "ProductOrderList";
    }
}
