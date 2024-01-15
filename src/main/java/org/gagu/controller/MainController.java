package org.gagu.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class MainController {

    @GetMapping("/main")
    public String showIndexPage() {
        return "index";
    }

    @PostMapping("/main")
    public String handleMainPg() {
        return "index";
    }
}
