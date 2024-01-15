package org.gagu.controller.businessPartner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.dto.business.RegisterResponse;
import org.gagu.service.businessPartner.BusinessPartnerService;
import org.gagu.service.businessPartner.PartnerService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.gagu.entity.businessPartner.QBusinessPartner.businessPartner;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BusinessPartnerController {
    private final BusinessPartnerService businessPartnerService;
    private final PartnerService partnerService;

    @GetMapping("/partnerList")
    public String getPartnerList(Model model,
                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                 @RequestParam(value = "page", defaultValue = "0") int page)
    {
        Page<BusinessPartnerResponse> getPartnerList = businessPartnerService.getPartnerList(size, page);

        model.addAttribute("list", getPartnerList);

        return "businessPartner";
    }

    @GetMapping("/register")
    public void getRegisterPage() {
        log.info("--------------- Controller for GETMAPPING TO register ---------------------");
    }

    @PostMapping("/register")
    public String postRegister(RegisterResponse registerResponse, Model model) {
        log.info("---------- POST TO REGISTER ---------------");

        log.info("Received RegisterResponse: {}", registerResponse);
        RegisterResponse businessPartnerResponse = partnerService.registerResponse(registerResponse);

        model.addAttribute("businessPartnerResponse", businessPartnerResponse);

        return "redirect:/partnerList";
    }
}
