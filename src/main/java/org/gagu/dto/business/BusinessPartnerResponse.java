package org.gagu.dto.business;

import lombok.*;

@Data
@RequiredArgsConstructor
@Builder
public class BusinessPartnerResponse {
    private final int partnerId;
    private final String bpName;
    private final String companyNumber;
    private final String phone;
    private final String address;
}
