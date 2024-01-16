package org.gagu.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ProductOrderItemListDTO {
    private Integer productOrderItemId;
    private String productId;
    private Integer productOrderId;
    private String productSpecification;
    private Integer productOrderItemQuantity;
    private Integer productOrderItemPrice;
    private Integer productOrderItemTotalprice;
    private Integer productOrderItemTotalpriceaddedtax;
    private String productOrderItemNote;

    public ProductOrderItemListDTO(Integer productOrderItemId,
                                   String productId,
                                   Integer productOrderId,
                                   String productSpecification,
                                   Integer productOrderItemQuantity,
                                   Integer productOrderItemPrice,
                                   Integer productOrderItemTotalprice,
                                   Integer productOrderItemTotalpriceaddedtax,
                                   String productOrderItemNote) {

        this.productOrderItemId = productOrderItemId;
        this.productId = productId;
        this.productOrderId = productOrderId;
        this.productSpecification = productSpecification;
        this.productOrderItemQuantity = productOrderItemQuantity;
        this.productOrderItemPrice = productOrderItemPrice;
        this.productOrderItemTotalprice = productOrderItemTotalprice;
        this.productOrderItemTotalpriceaddedtax = productOrderItemTotalpriceaddedtax;
        this.productOrderItemNote = productOrderItemNote;

    }
}
