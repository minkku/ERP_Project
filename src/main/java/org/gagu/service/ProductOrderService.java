package org.gagu.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gagu.dto.ProductOrderListDTO;
import org.gagu.repository.ProductOrderRepository;
import org.gagu.repository.ProductOrderRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductOrderService {
    private final ProductOrderRepository productOrderRepository;

    @Autowired
    public ProductOrderService(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    public List<ProductOrderListDTO> getProductOrderList(Pageable pageable) {
        return productOrderRepository.findProductOrderList(pageable);
    }

    public long getProductOrderListCount() {
        return productOrderRepository.findProductOrderListCount();
    }
}
