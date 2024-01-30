package org.gagu.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.ProductOrderCustomDTO;
import org.gagu.entity.ProductOrderItem;
import org.gagu.service.ProductPurchaseOrderCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Log4j2
public class ProductPurchaseOrderCreationController {
    @Autowired
    ProductPurchaseOrderCreationService productPurchaseOrderCreationService;

    @GetMapping("/ProductPurchaseOrderCreation")
    public String getProductPurchaseOrderCreation(Model model) {
        String productOrderNumber = productPurchaseOrderCreationService.newPOCode();
        model.addAttribute("productOrderNumber", productOrderNumber);
        return "ProductPurchaseOrderCreation";
    }

    @PostMapping("/ProductPurchaseOrderCreation")
    public String register(@ModelAttribute ProductOrderCustomDTO productOrderCustomDTO, @RequestParam("productOrderDeliveryDate") String productOrderDeliveryDate) {
        Timestamp productOrderDeliverydate = Timestamp.valueOf(productOrderDeliveryDate + " 00:00:00");
        productOrderCustomDTO.setProductOrderDeliverydate(productOrderDeliverydate);
        log.info(productOrderCustomDTO);

        return "redirect:/ProductPurchaseOrderCreation";
    }

    @PostMapping(value = "/ProductPurchaseOrderItemCreation", consumes = "application/json")
    public ResponseEntity<String> registerItem(@RequestBody String jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonData);

            // 필요한 필드에 따라 적절하게 데이터를 추출하고 처리
            String productOrderNumber = jsonNode.get("productOrderNumber").asText();
            JsonNode productOrderItemListNode = jsonNode.get("productOrderItemList");
            List<ProductOrderItem> productOrderItemList = objectMapper.convertValue(productOrderItemListNode, new TypeReference<List<ProductOrderItem>>() {});


            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            log.error("Error processing product order items", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing product order items");
        }
    }
}
