package org.gagu.repository;

import org.gagu.dto.ProductOrderListDTO;
import org.gagu.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository {
    List<ProductOrderListDTO> findProductOrderList();
}
