package org.gagu.controller.businessPartner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.dto.business.RegisterResponse;
import org.gagu.entity.businessPartner.BusinessPartner;
import org.gagu.service.businessPartner.BusinessPartnerService;
import org.gagu.service.businessPartner.PartnerService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping("/businessPartner")
    public BusinessPartner register(@RequestBody RegisterResponse responseDTO) {
        log.info("---------- POST TO REGISTER ---------------");
        return partnerService.registerResponse(responseDTO);
    }


    @PostMapping("/businessPartner/{partnerId}")
    public ResponseEntity<BusinessPartner> updatePartner(@RequestParam int partnerId, @RequestBody RegisterResponse response) {
        Optional<BusinessPartner> updatedPartner = partnerService.updatePartnerById(partnerId, response);

        if (updatedPartner.isPresent()) {
            return new ResponseEntity<>(updatedPartner.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
