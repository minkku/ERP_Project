package org.gagu.controller.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class ComponentController {
    private final ComponentService componentService;

    @GetMapping("/componentList")
    public String getComponentList(){
        return null;
    }
}
