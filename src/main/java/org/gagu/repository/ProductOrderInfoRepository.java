package org.gagu.repository;

import org.gagu.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderInfoRepository extends JpaRepository<ProductOrder, Integer> {
    @Query("SELECT po " +
           "FROM ProductOrder po " +
           "WHERE po.productOrderId = :productOrderId")
    ProductOrder findByProductOrderId (Integer productOrderId);

}
