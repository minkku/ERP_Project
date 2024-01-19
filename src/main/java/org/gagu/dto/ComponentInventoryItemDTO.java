package org.gagu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ComponentInventoryItemDTO {
    String componentId;
    Integer productNecessarycomponentaAount;
    Integer componentInventoryQuantity;

    public ComponentInventoryItemDTO(String componentId, Integer productNecessarycomponentaAount,
                                   Integer componentInventoryQuantity) {
        this.componentId = componentId;
        this.productNecessarycomponentaAount = productNecessarycomponentaAount;
        this.componentInventoryQuantity = componentInventoryQuantity;
    }
}
