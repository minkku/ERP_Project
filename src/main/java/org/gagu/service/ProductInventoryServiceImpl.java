package org.gagu.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gagu.entity.ProductInventory;
import org.gagu.entity.ProductOrder;
import org.gagu.entity.ProductOrderItem;
import org.gagu.repository.ProductInventoryRepository;
import org.gagu.repository.ProductOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductInventoryServiceImpl implements ProductInventoryService {
    @Autowired
    private final ProductInventoryRepository productInventoryRepository;
    @Autowired
    private final ProductOrderItemRepository productOrderItemRepository;

    @Override
    public boolean updateProductInventory(Integer productOrderId) {
        List<ProductOrderItem> productOrderItems = productOrderItemRepository.findProductOrderItemsByProductOrderId(productOrderId);

        if (productOrderId != null) {
        for (ProductOrderItem poi : productOrderItems) {
            ProductInventory updateProductInventory = productInventoryRepository.findProductInventoryByProductId(poi.getProductId());
            updateProductInventory = updateProductInventory.toBuilder()
                    .productInventoryQuantity(updateProductInventory.getProductInventoryQuantity() - poi.getProductOrderItemQuantity())
                    .build();
            System.out.println("오더아이템 정보" + poi.getProductId() + "수량====" + poi.getProductOrderItemQuantity() +"\n인벤토리 ===" + updateProductInventory.getProductInventoryQuantity());
            productInventoryRepository.save(updateProductInventory);
        }
            return true;
        } else {
            return false;
        }
    }
}
