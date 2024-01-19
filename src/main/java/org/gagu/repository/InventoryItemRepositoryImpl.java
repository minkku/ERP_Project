package org.gagu.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.ComponentInventoryItemDTO;
import org.gagu.dto.ProductInventoryItemDTO;
import org.gagu.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
public class InventoryItemRepositoryImpl implements InventoryItemRepository {
    @Autowired
    private final JPAQueryFactory jpaQueryFactory;

    public InventoryItemRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<ProductInventoryItemDTO> findProductNecessaryInventoryByOProductOrderId(Integer productOrderId) {
        QProduct qProduct = QProduct.product;
        QProductOrder qProductOrder = QProductOrder.productOrder;
        QProductOrderItem qProductOrderItem = QProductOrderItem.productOrderItem;
        QProductInventory qProductInventory = QProductInventory.productInventory;

        List<ProductInventoryItemDTO> result = jpaQueryFactory
                .select(Projections.bean(ProductInventoryItemDTO.class,
                        qProduct.productId,
                        qProductOrderItem.productOrderItemQuantity,
                        qProductInventory.productInventoryQuantity))
                .from(qProductOrderItem)
                .join(qProduct).on(qProductOrderItem.productId.eq(qProduct.productId))
                .join(qProductOrder).on(qProductOrderItem.productOrderId.eq(qProductOrder.productOrderId))
                .join(qProductInventory).on(qProductOrderItem.productId.eq(qProductInventory.productId))
                .where(qProductOrderItem.productOrderId.eq(productOrderId))
                .fetch();
        for (ProductInventoryItemDTO dto : result) {
            log.info("ProductInventoryItemDTO: {}", dto);
        }
        return result;
    }

    @Override
    public List<ComponentInventoryItemDTO> findComponentNecessaryInventoryByProductId(String productId) {
        QComponent qComponent = QComponent.component;
        QProduct qProduct = QProduct.product;
        QProductNecessarycomponent qProductNecessarycomponent = QProductNecessarycomponent.productNecessarycomponent;
        QComponentInventory qComponentInventory = QComponentInventory.componentInventory;

        List<ComponentInventoryItemDTO> result = jpaQueryFactory
                .select(Projections.bean(ComponentInventoryItemDTO.class,
                        qComponent.componentId,
                        qProductNecessarycomponent.productNecessarycomponentAmount,
                        qComponentInventory.componentInventoryQuantity))
                .from(qProductNecessarycomponent)
                .join(qComponent).on(qProductNecessarycomponent.componentId.eq(qComponent.componentId))
                .join(qComponentInventory).on(qProductNecessarycomponent.componentId.eq(qComponentInventory.componentId))
                .join(qProduct).on(qProductNecessarycomponent.productId.eq(qProduct.productId))
                .where(qProductNecessarycomponent.productId.eq(productId))
                .fetch();
        for (ComponentInventoryItemDTO dto : result) {
            log.info("ComponentInventoryItemDTO: {}", dto);
        }
        return result;
    }
}
