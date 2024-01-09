package org.gagu.controller;

import lombok.extern.log4j.Log4j2;
import org.gagu.entity.ComponentOrder;
import org.gagu.service.ComponentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@Log4j2
public class MainController {

    @GetMapping("/main")
    public String showIndexPage() {
        return "index";
    }
}
