package org.gagu.repository.sale;

import org.gagu.dto.sale.ProductOrderItemListDTO;
import org.gagu.dto.sale.ProductOrderListDTO;
import org.gagu.entity.ProductOrder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository {
    List<ProductOrderListDTO> findProductOrderList(Pageable pageable);

    long findProductOrderListCount();

    ProductOrder findByProductOrderId(Integer productOrderId);

    List<ProductOrderItemListDTO> findProductOrderItemsByProductOrderId(Integer productOrderId);
}
