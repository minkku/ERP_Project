package org.gagu.dto.vender;

import lombok.*;

@Data
@RequiredArgsConstructor
@Builder
public class VenderResponse {
    private final int venderId;
    private final String venderName;
    private final String companyNum;
    private final String phone;
    private final String address;
}
