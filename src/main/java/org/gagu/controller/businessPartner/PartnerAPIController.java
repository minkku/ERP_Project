package org.gagu.controller.businessPartner;

import lombok.RequiredArgsConstructor;
import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.dto.business.UpdateRequest;
import org.gagu.entity.businessPartner.BusinessPartner;
import org.gagu.service.businessPartner.BusinessPartnerService;
import org.gagu.service.businessPartner.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PartnerAPIController {
    private final PartnerService partnerService;

    @PutMapping("/{partnerId}")
    public ResponseEntity<String> updatePartner(@PathVariable int partnerId, @RequestBody UpdateRequest updateRequest) {
        partnerService.updatePartner(partnerId, updateRequest);
        return ResponseEntity.ok("Partner updated successfully");
    }
}
