package org.gagu.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@Log4j2
public class SaleController {
    @GetMapping("/orderStatus")
    public String getOrdersStatus() {
        return "orderStatus";
    }
}
