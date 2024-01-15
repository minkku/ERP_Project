package org.gagu.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.ProductOrderListDTO;
import org.gagu.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
public class ProductOrderRepositoryImpl implements ProductOrderRepository {
    @Autowired
    private final JPAQueryFactory jpaQueryFactory;

    public ProductOrderRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<ProductOrderListDTO> findProductOrderList(Pageable pageable) {
        QProduct qProduct = QProduct.product;
        QProductOrder qProductOrder = QProductOrder.productOrder;
        QProductOrderItem qProductOrderItem = QProductOrderItem.productOrderItem;
        QBusinessVender qBusinessVender = QBusinessVender.businessVender;

        List<ProductOrderListDTO> result = jpaQueryFactory
                .select(Projections.bean(ProductOrderListDTO.class,
                        qProductOrder.productOrderNumber,
                        qProductOrder.productOrderOrderdate.max().as("productOrderOrderdate"),
                        qBusinessVender.businessvenderName,
                        qProduct.productId.max().as("productName"),
                        qProductOrderItem.productOrderItemId.count().intValue().as("productOrderItemQuantity"),
                        qProductOrder.productOrderPriceAmount.max().as("productOrderPriceAmount"),
                        qProductOrder.productOrderStatus.max().as("productOrderStatus"),
                        qProductOrder.productOrderId))
                .from(qProductOrder)
                .join(qBusinessVender).on(qProductOrder.businessvenderId.eq(qBusinessVender.businessvenderId))
                .join(qProductOrderItem).on(qProductOrder.productOrderId.eq(qProductOrderItem.productOrderId))
                .join(qProduct).on(qProductOrderItem.productId.eq(qProduct.productId))
                .groupBy(qProductOrder.productOrderId)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        for (ProductOrderListDTO dto : result) {
            log.info("ProductOrderListDTO: {}", dto);
        }
        return result;
    }

    @Override
    public long findProductOrderListCount() {
        QProductOrder qProductOrder = QProductOrder.productOrder;
        return jpaQueryFactory
                .selectFrom(qProductOrder)
                .fetchCount();
    }
}