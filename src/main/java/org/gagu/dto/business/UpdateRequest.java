package org.gagu.dto.business;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
public class UpdateRequest {
    private String bpName;
    private String companyNumber;
    private String phone;
    private String fax;
    private String address;
    private String headName;
    private String type;
    private String note;
    private String bigType;
    private String smallType;
}
