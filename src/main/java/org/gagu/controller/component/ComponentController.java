package org.gagu.controller.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.component.ComponentResponse;
import org.gagu.entity.component.ComponentOrder;
import org.gagu.service.Component.ComponentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Log4j2
public class ComponentController {
    private final ComponentService componentService;

    @GetMapping("/componentList")
    public String getComponentList(Model model,
                                   @PageableDefault(size = 10)Pageable pageable)
    {
        Page<ComponentOrder> getComponentList = componentService.findAll(pageable);

        model.addAttribute("list", getComponentList);

        return "components-orders";
    }
}
