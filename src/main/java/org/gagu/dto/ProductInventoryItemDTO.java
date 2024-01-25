package org.gagu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ProductInventoryItemDTO {
    String productId;
    Integer productOrderItemQuantity;
    Integer productInventoryQuantity;

    public ProductInventoryItemDTO(String productId, Integer productOrderItemQuantity,
                                   Integer productInventoryQuantity) {
        this.productId = productId;
        this.productOrderItemQuantity = productOrderItemQuantity;
        this.productInventoryQuantity = productInventoryQuantity;
    }
}
