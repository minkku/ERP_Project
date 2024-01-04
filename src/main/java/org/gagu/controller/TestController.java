package org.gagu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class TestController {
    @RequestMapping("/")
    public String test() {
        return "index";
    }
}
