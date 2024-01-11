package org.gagu.dto.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterResponse {
    private int partnerId;
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
