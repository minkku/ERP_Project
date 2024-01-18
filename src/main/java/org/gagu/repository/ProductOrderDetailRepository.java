package org.gagu.repository;

import org.gagu.entity.BusinessVender;
import org.gagu.entity.ProductOrder;
import org.gagu.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductOrderDetailRepository  extends JpaRepository<ProductOrder, Integer> {
    @Query("SELECT po " +
           "FROM ProductOrder po " +
           "WHERE po.productOrderId = :productOrderId")
    ProductOrder findByProductOrderId (Integer productOrderId);

}
