package org.gagu.dto.business;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteRequest {
    private int partnerId;
}
