package org.gagu.dto.component;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
@Builder
public class ComponentResponse {
    private final int componentOrderId;
    private final String componentId;
    private final String vendorName;
    private final String orderForm;
    private final Timestamp orderDate;
    private final Timestamp deliveryDate;
    private final Timestamp receiptDate;
    private final int amount;
    private final int negoAmount;
}
