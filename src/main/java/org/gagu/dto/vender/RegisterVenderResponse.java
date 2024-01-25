package org.gagu.dto.vender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterVenderResponse {
    private int venderId;
    private String venderName;
    private String companyNum;
    private String phone;
    private String fax;
    private String address;
    private String headName;
    private String type;
    private String note;
    private String bigType;
    private String smallType;
}
