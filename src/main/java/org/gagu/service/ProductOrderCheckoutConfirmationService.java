package org.gagu.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gagu.dto.ComponentInventoryItemDTO;
import org.gagu.dto.ProductInventoryItemDTO;
import org.gagu.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductOrderCheckoutConfirmationService {
    private final InventoryItemRepository inventoryItemRepository;

    public List<ProductInventoryItemDTO> getProductInventoryItemList(Integer productOrderId) {
        return inventoryItemRepository.findProductNecessaryInventoryByOProductOrderId(productOrderId);
    }
    public List<ComponentInventoryItemDTO> getComponentInventoryItemList(String productId) {
        return inventoryItemRepository.findComponentNecessaryInventoryByProductId(productId);
    }
}
