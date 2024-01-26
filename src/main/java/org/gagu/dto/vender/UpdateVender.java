package org.gagu.dto.vender;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
public class UpdateVender {
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
