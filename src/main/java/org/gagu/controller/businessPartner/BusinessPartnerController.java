package org.gagu.controller.businessPartner;

import lombok.RequiredArgsConstructor;
import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.service.businessPartner.BusinessPartnerService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/partner")
@RequiredArgsConstructor
public class BusinessPartnerController {
    private final BusinessPartnerService businessPartnerService;

    @GetMapping("/partnerList")
    public String getPartnerList(Model model,
                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                 @RequestParam(value = "page", defaultValue = "0") int page)
    {
        Page<BusinessPartnerResponse> getPartnerList = businessPartnerService.getPartnerList(size, page);

        model.addAttribute("list", getPartnerList);

        return "/partner/partnerList";
    }
}
