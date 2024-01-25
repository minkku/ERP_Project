package org.gagu.controller.vender;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.vender.RegisterVenderResponse;
import org.gagu.dto.vender.VenderResponse;
import org.gagu.entity.vender.Vender;
import org.gagu.service.vender.VenderService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequiredArgsConstructor
@Log4j2
public class VenderController {
    private final VenderService venderService;
    @GetMapping("/venderList")
    public String getVenderList(Model model,
                                @RequestParam(value = "size", defaultValue = "10") int size,
                                @RequestParam(value = "page", defaultValue = "0")int page)
    {
        Page<VenderResponse> getVenderList = venderService.getVenderList(size, page);

        model.addAttribute("list", getVenderList);

        return "vender";
    }

    @PostMapping("/vender")
    public Vender register(@RequestParam RegisterVenderResponse response) {
        log.info("-------- POST VENDER DATA -----------");
        return venderService.registerVender(response);
    }
}