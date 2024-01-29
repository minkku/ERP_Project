package org.gagu.controller;

import lombok.extern.log4j.Log4j2;
import org.gagu.dto.*;
import org.gagu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
public class ProductOrderCheckoutConfirmationController {
    private final ProductOrderService productOrderService;
    private final ProductOrderInfoService productOrderInfoService;
    private final ProductOrderCheckoutConfirmationService productOrderCheckoutConfirmationService;
    private final ProductInventoryService productInventoryService;
    private final ProductSalesHistoryService productSalesHistoryService;

    @Autowired
    public ProductOrderCheckoutConfirmationController(ProductOrderService productOrderService, ProductOrderInfoService productOrderDetailService, ProductOrderCheckoutConfirmationService productOrderCheckoutConfirmationService, ProductInventoryService productInventoryService, ProductSalesHistoryService productSalesHistoryService) {
        this.productOrderService = productOrderService;
        this.productOrderInfoService = productOrderDetailService;
        this.productOrderCheckoutConfirmationService = productOrderCheckoutConfirmationService;
        this.productInventoryService = productInventoryService;
        this.productSalesHistoryService = productSalesHistoryService;
    }

    @GetMapping("/ProductOrderCheckoutConfirmation")
    public String getOrderCheckoutConfirmation(@RequestParam(defaultValue = "0", required = false) int page,
                                               @RequestParam(defaultValue = "10", required = false) int pageSize,
                                               Model model) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<ProductOrderListDTO> productOrderCheckoutList = productOrderService.getProductOrderCheckoutList(pageable);
        model.addAttribute("ProductOrderCheckoutList", productOrderCheckoutList);

        // Calculate total pages dynamically based on total item count
        long totalItems = productOrderService.getProductOrderCheckoutListCount(); // You need to implement this method
        int totalPages = (int) Math.max(1, Math.ceil((double) totalItems / pageSize));

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);

        return "ProductOrderCheckoutConfirmation";
    }

    @GetMapping("/ProductOrderCheckoutConfirmationModal")
    public ResponseEntity<Map<String, Object>> getModalData(@RequestParam("productOrderId") Integer productOrderId) {
        ProductOrderInfoDataDTO productOrderInfoDataDTO = productOrderService.ProductOrderInfoData(productOrderId);
        MemberCustomDTO memberCustomDTO = productSalesHistoryService.getMemberCustomDTO(productOrderId, productOrderInfoDataDTO.getProductOrder().getMemberId());
        Map<String, Object> modalData = new HashMap<>();
        modalData.put("response", productOrderInfoDataDTO);
        modalData.put("member", memberCustomDTO);
        return ResponseEntity.ok(modalData);
    }

    @GetMapping("/ProductInventoryItemModal")
    public ResponseEntity<List<ProductInventoryItemDTO>> getProductInventoryItem(@RequestParam("productOrderId") Integer productOrderId) {
        List<ProductInventoryItemDTO> modalData = productOrderCheckoutConfirmationService.getProductInventoryItemList(productOrderId);
        log.info(modalData + "=  상품재고및 필요수량");
        return modalData != null ? ResponseEntity.ok(modalData) : ResponseEntity.notFound().build();
    }
    @GetMapping("/ComponentInventoryItemModal")
    public ResponseEntity<Map<String, Object>> getComponentInventoryItem(@RequestParam("productId") String productId,
                                                          @RequestParam("productOrderId") Integer productOrderId) {
        List<ComponentInventoryItemDTO> componentInventoryItemList = productOrderCheckoutConfirmationService.getComponentInventoryItemList(productId);
        ProductInventoryItemDTO productInventoryItem = productOrderCheckoutConfirmationService.getProductInventoryItem(productId, productOrderId);

        Map<String, Object> modalData = new HashMap<>();
        modalData.put("component", componentInventoryItemList);
        modalData.put("product", productInventoryItem);
        log.info(modalData + "=  상품,부품재고및 필요수량");
        return ResponseEntity.ok(modalData);
    }

    @PostMapping("/ProductOrderCheckoutConfirmationModal")
    public ResponseEntity<Void> updateProductOrderStatus(@RequestParam("productOrderId") Integer productOrderId,
                                                         @RequestParam("updateStatus") int updateStatus) {
        log.info("출고확정컨트롤러");
        productOrderInfoService.updateProductOrderStatus(productOrderId, updateStatus);
        log.info("\nproductOrderId = " + productOrderId + "\nupdateStatus = " + updateStatus);
        productInventoryService.updateProductInventory(productOrderId);
        log.info(productOrderInfoService.updateProductOrderStatus(productOrderId, updateStatus));
        return ResponseEntity.noContent().build();
    }
}
