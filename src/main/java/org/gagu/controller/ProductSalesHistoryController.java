package org.gagu.controller;

import lombok.extern.log4j.Log4j2;
import org.gagu.dto.MemberCustomDTO;
import org.gagu.dto.ProductOrderInfoDataDTO;
import org.gagu.dto.ProductOrderListDTO;
import org.gagu.entity.member.Member;
import org.gagu.service.ProductOrderCheckoutConfirmationService;
import org.gagu.service.ProductOrderInfoService;
import org.gagu.service.ProductOrderService;
import org.gagu.service.ProductSalesHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j2
public class ProductSalesHistoryController {
    private final ProductOrderService productOrderService;
    private final ProductOrderInfoService productOrderInfoService;
    private final ProductOrderCheckoutConfirmationService productOrderCheckoutConfirmationService;

    private final ProductSalesHistoryService productSalesHistoryService;

    @Autowired
    public ProductSalesHistoryController(ProductOrderService productOrderService, ProductOrderInfoService productOrderDetailService, ProductOrderCheckoutConfirmationService productOrderCheckoutConfirmationService, ProductSalesHistoryService productSalesHistoryService) {
        this.productOrderService = productOrderService;
        this.productOrderInfoService = productOrderDetailService;
        this.productOrderCheckoutConfirmationService = productOrderCheckoutConfirmationService;
        this.productSalesHistoryService = productSalesHistoryService;
    }

    @GetMapping("/ProductSalesHistory")
    public String getOrderList(@RequestParam(defaultValue = "0", required = false) int page,
                               @RequestParam(defaultValue = "10", required = false) int pageSize,
                               Model model) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<ProductOrderListDTO> productOrderList = productOrderService.getProductSalesList(pageable);
        model.addAttribute("ProductOrderList", productOrderList);

        // Calculate total pages dynamically based on total item count
        long totalItems = productOrderService.getProductSalesCount(); // You need to implement this method
        int totalPages = (int) Math.max(1, Math.ceil((double) totalItems / pageSize));

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);

        return "ProductSalesHistory";
    }

    @GetMapping("/ProductPurchaseOrder")
    public String getPurchaseInfo(@RequestParam("productOrderId") Integer productOrderId, Model model) {
        ((ModelMap) model).clear();
        ProductOrderInfoDataDTO windowData = productOrderService.ProductOrderInfoData(productOrderId);
        Integer productId = productOrderService.getProductOrderByProductOrderId(productOrderId).getMemberId();
        MemberCustomDTO memberCustom = productSalesHistoryService.getMemberCustomDTO(productOrderId, productId);
        log.info("windowData=========================" + windowData);
        log.info("memberCustom=========================" + memberCustom);
        model.addAttribute("member", memberCustom);
        model.addAttribute("windowData", windowData);
        model.addAttribute("productOrderId", productOrderId);
        log.info("PurchaseOrder ============" + productOrderId);
        return "ProductPurchaseOrder";
    }
}
