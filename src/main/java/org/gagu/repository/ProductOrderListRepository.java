package org.gagu.repository;

import org.gagu.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderListRepository extends JpaRepository<ProductOrder, Integer> {
}
