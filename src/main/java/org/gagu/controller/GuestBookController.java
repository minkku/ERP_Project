package org.gagu.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guestbook")
@Log4j2
public class GuestBookController {
    @GetMapping({"/", "/list"})
    public String list() {
        log.info("Get list page-------");
        return "/guestbook/list";
    }
}