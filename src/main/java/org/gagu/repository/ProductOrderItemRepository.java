package org.gagu.repository;

import org.gagu.entity.ProductOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderItemRepository extends JpaRepository<ProductOrderItem, Integer> {
    @Query("SELECT poi " +
             "FROM ProductOrderItem poi " +
            "WHERE poi.productOrderId = :productOrderId")
    public List<ProductOrderItem> findProductOrderItemsByProductOrderId(Integer productOrderId);
}
