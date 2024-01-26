package org.gagu.controller.businessPartner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.business.BusinessPartnerDetailResponse;
import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.dto.business.UpdateRequest;
import org.gagu.service.businessPartner.PartnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j2
public class PartnerAPIController {
    private final PartnerService partnerService;

    @GetMapping("detail/{partnerId}")
    public String detail(@PathVariable("partnerId") int partnerId, Model model) {
        BusinessPartnerDetailResponse businessPartnerDetailResponse = partnerService.getDetail(partnerId);

        model.addAttribute("DetailRes", businessPartnerDetailResponse);
        return "businessPartner";
    }

    @PutMapping("/updating")
    public ResponseEntity<String> updatePartner(@RequestParam("partnerId") int partnerId, @RequestBody UpdateRequest request) {
        log.info("putmapping---------------------------------");
        try {
            partnerService.updatePartner(partnerId, request);
            return ResponseEntity.ok("Success to update : " + partnerId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail to update : " + e.getMessage());
        }
    }
}
