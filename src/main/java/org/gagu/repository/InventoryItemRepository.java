package org.gagu.repository;

import org.gagu.dto.ComponentInventoryItemDTO;
import org.gagu.dto.ProductInventoryItemDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryItemRepository {
    List<ProductInventoryItemDTO> findProductNecessaryInventoryByOProductOrderId(Integer productOrderId);

    List<ComponentInventoryItemDTO> findComponentNecessaryInventoryByProductId(String productId);

    ProductInventoryItemDTO findProductInventoryByProductId(String productId, Integer productOrderId);
}
