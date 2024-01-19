package org.gagu.controller.businessPartner;

import lombok.RequiredArgsConstructor;
import org.gagu.dto.business.BusinessPartnerDetailResponse;
import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.dto.business.UpdateRequest;
import org.gagu.service.businessPartner.PartnerService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PartnerAPIController {
    private final PartnerService partnerService;

    @GetMapping("detail/{partnerId}")
    public ResponseEntity<BusinessPartnerResponse> getBusinessPartnerDetail(@PathVariable int partnerId) {
        try {
            BusinessPartnerDetailResponse partnerDetailResponse = partnerService.getBusinessPartnerDetail(partnerId);
            return new ResponseEntity<>(partnerDetailResponse, HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updating")
    public ResponseEntity<String> updatePartner(@RequestParam int partnerId,@RequestBody UpdateRequest request) {
        try {
            partnerService.updatePartner(partnerId,request);
            return ResponseEntity.ok("Success to update : " + partnerId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail to update : " + e.getMessage());
        }
    }
}
