package org.gagu.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.ProductOrderListDTO;
import org.gagu.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showOrderStatus(@RequestParam(defaultValue = "0", required = false) int page,
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
    private int calculateTotalPages() {
        // Implement logic to calculate total pages
        return 10; // Replace with your actual calculation
    }
}