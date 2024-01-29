package org.gagu.controller;

import lombok.extern.log4j.Log4j2;
import org.gagu.dto.MemberCustomDTO;
import org.gagu.dto.ProductOrderInfoDataDTO;
import org.gagu.dto.ProductOrderListDTO;
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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
public class ProductOrderController {
    private final ProductOrderService productOrderService;
    private final ProductOrderInfoService productOrderInfoService;
    private final ProductOrderCheckoutConfirmationService productOrderCheckoutConfirmationService;
    private final ProductSalesHistoryService productSalesHistoryService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService, ProductOrderInfoService productOrderDetailService, ProductOrderCheckoutConfirmationService productOrderCheckoutConfirmationService, ProductSalesHistoryService productSalesHistoryService) {
        this.productOrderService = productOrderService;
        this.productOrderInfoService = productOrderDetailService;
        this.productOrderCheckoutConfirmationService = productOrderCheckoutConfirmationService;
        this.productSalesHistoryService = productSalesHistoryService;
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
        int totalPages = (int) Math.max(1, Math.ceil((double) totalItems / pageSize));

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);

        return "ProductOrderStatus";
    }

    @GetMapping("/ProductOrderInfoModal")
    public ResponseEntity<Map<String, Object>> getModalData(@RequestParam("productOrderId") Integer productOrderId) {
        ProductOrderInfoDataDTO productOrderInfoDataDTO = productOrderService.ProductOrderInfoData(productOrderId);
        MemberCustomDTO memberCustomDTO = productSalesHistoryService.getMemberCustomDTO(productOrderId, productOrderInfoDataDTO.getProductOrder().getMemberId());
        Map<String, Object> modalData = new HashMap<>();
        modalData.put("response", productOrderInfoDataDTO);
        modalData.put("member", memberCustomDTO);
        return ResponseEntity.ok(modalData);
    }

    @PostMapping("/ProductOrderInfoModal")
    public ResponseEntity<Void> updateProductOrderStatus(@RequestParam("productOrderId") Integer productOrderId,
                                                         @RequestParam("updateStatus") int updateStatus) {

        productOrderInfoService.updateProductOrderStatus(productOrderId, updateStatus);
        log.info("\nproductOrderId = " + productOrderId + "\nupdateStatus = " + updateStatus);
        log.info(productOrderInfoService.updateProductOrderStatus(productOrderId, updateStatus));
        return ResponseEntity.noContent().build();
    }
}
