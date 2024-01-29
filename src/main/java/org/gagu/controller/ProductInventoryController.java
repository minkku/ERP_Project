package org.gagu.controller;
import org.gagu.entity.Product;
import org.gagu.entity.ProductInventory;
import org.gagu.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class ProductInventoryController {

    private final ProductInventoryService productInventoryService;

    @Autowired
    public ProductInventoryController(ProductInventoryService productInventoryService) {
        this.productInventoryService = productInventoryService;
    }

    @GetMapping("/product-inventory")
    public String getProductInventory(Model model) {
        List<ProductInventory> productInventories = productInventoryService.getAllProductInventories();
        model.addAttribute("products", productInventories);
        return "product-inventory";
    }

    @GetMapping("/product-detail")
    @ResponseBody
    public Product getProductDetail(@RequestParam String productId) {
        return productInventoryService.getProductDetailsById(productId);
    }


}