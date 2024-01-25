package org.gagu.controller;

import lombok.extern.log4j.Log4j2;

import org.gagu.dto.ProductOrderInfoDataDTO;
import org.gagu.dto.ProductOrderListDTO;
import org.gagu.service.ProductOrderDetailService;
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
public class ProductOrderController {
    private final ProductOrderService productOrderService;
    private final ProductOrderDetailService productOrderDetailService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService, ProductOrderDetailService productOrderDetailService) {
        this.productOrderService = productOrderService;
        this.productOrderDetailService = productOrderDetailService;
    }

    @GetMapping("/ProductOrderStatus")
    public String getOrderStatus(@RequestParam(defaultValue = "0", required = false) int page,
                                  @RequestParam(defaultValue = "10", required = false) int pageSize,
                                  Model model) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<ProductOrderListDTO> productOrderList = productOrderService.getProductOrderList(pageable);
        model.addAttribute("ProductOrderList", productOrderList);

        // Calculate total pages dynamically based on total item count
        long totalItems = productOrderService.getProductOrderListCount(); // You need to implement this method
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);

        return "ProductOrderStatus";
    }

    @GetMapping("/ProductOrderInfoModal")
    public ResponseEntity<ProductOrderInfoDataDTO> getModalData(@RequestParam("productOrderId") Integer productOrderId) {
        ProductOrderInfoDataDTO modalData = productOrderService.ProductOrderInfoData(productOrderId);
        return modalData != null ? ResponseEntity.ok(modalData) : ResponseEntity.notFound().build();
    }

    @PostMapping("/ProductOrderInfoModal")
    public ResponseEntity<Void> updateProductOrderStatus(@RequestParam("productOrderId") Integer productOrderId,
                                                         @RequestParam("updateStatus") int updateStatus) {

        productOrderDetailService.updateProductOrderStatus(productOrderId, updateStatus);
        log.info("productOrderId = " + productOrderId + "\nupdateStatus = " + updateStatus);
        log.info(productOrderDetailService.updateProductOrderStatus(productOrderId, updateStatus));
        return ResponseEntity.noContent().build();
    }
}
