package org.gagu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ComponentInventoryItemDTO {
    String componentId;
    Integer productNecessarycomponentAmount;
    Integer componentInventoryQuantity;

    public ComponentInventoryItemDTO(String componentId, Integer productNecessarycomponentAmount,
                                   Integer componentInventoryQuantity) {
        this.componentId = componentId;
        this.productNecessarycomponentAmount = productNecessarycomponentAmount;
        this.componentInventoryQuantity = componentInventoryQuantity;
    }
}
