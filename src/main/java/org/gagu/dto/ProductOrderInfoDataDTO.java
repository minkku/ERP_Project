package org.gagu.dto;

import lombok.Builder;
import lombok.Data;
import org.gagu.entity.BusinessVender;
import org.gagu.entity.ProductOrder;
import org.gagu.entity.ProductOrderItem;

import java.util.List;

@Data
@Builder
public class ProductOrderInfoDataDTO {
    private ProductOrder productOrder;
    private List<ProductOrderItemListDTO> productOrderItems;
    private BusinessVender businessVender;
}
