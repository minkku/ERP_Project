package org.gagu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
public class MemberCustomDTO {
    private Integer productOrderId;
    private Integer memberId;
    private String memberName;
    private String userId;
    private String password;
    private String department;
    private String position;
    private LocalDateTime regdate;

    public MemberCustomDTO(Integer productOrderId, Integer memberId, String memberName, String userId, String password, String department, String position, LocalDateTime regdate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.userId = userId;
        this.password = password;
        this.department = department;
        this.position = position;
        this.regdate = regdate;
    }
}
