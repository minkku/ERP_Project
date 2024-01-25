package org.gagu.dto.sale;

import lombok.Builder;
import lombok.Data;
import org.gagu.entity.BusinessVender;
import org.gagu.entity.ProductOrder;

import java.util.List;

@Data
@Builder
public class ProductOrderInfoDataDTO {
    private ProductOrder productOrder;
    private List<ProductOrderItemListDTO> productOrderItems;
    private BusinessVender businessVender;
}
