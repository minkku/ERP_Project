package org.gagu.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gagu.dto.ProductOrderItemListDTO;
import org.gagu.dto.ProductOrderListDTO;
import org.gagu.entity.BusinessVender;
import org.gagu.entity.ProductOrder;
import org.gagu.entity.ProductOrderItem;
import org.gagu.repository.BusinessVenderRepository;
import org.gagu.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductOrderService {
    private final ProductOrderRepository productOrderRepository;
    @Autowired
    private BusinessVenderRepository businessVenderRepository;

    public List<ProductOrderListDTO> getProductOrderList(Pageable pageable) {
        return productOrderRepository.findProductOrderList(pageable);
    }

    public long getProductOrderListCount() {
        return productOrderRepository.findProductOrderListCount();
    }

    public BusinessVender getBusinessVenderByProductOrderId(int productOrderId) {
        return businessVenderRepository.findBusinessVenderByProductOrderId(productOrderId);
    }

    public List<ProductOrderItemListDTO> getProductOrderItemsByProductOrderId(int productOrderId) {
        return productOrderRepository.findProductOrderItemsByProductOrderId(productOrderId);
    }

    public ProductOrder getProductOrderByProductOrderId(int productOrderId) {
        return productOrderRepository.findByProductOrderId(productOrderId);
    }
}
