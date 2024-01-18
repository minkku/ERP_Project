package org.gagu.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gagu.entity.Product;
import org.gagu.entity.ProductOrder;
import org.gagu.repository.ProductOrderDetailRepository;
import org.gagu.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductOrderDetailServiceImpl implements ProductOrderDetailService {
    @Autowired
    private final ProductOrderDetailRepository productOrderDetailRepository;


    @Override
    public boolean updateProductOrderStatus(Integer productOrderId, int productOrderStatus) {
        Optional<ProductOrder> optionalProductOrder = productOrderDetailRepository.findById(productOrderId);

        if (optionalProductOrder.isPresent()) {
            ProductOrder productOrder = optionalProductOrder.get();

            ProductOrder updatedProductOrder = productOrder.toBuilder()
                    .productOrderStatus(productOrderStatus)
                    .build();

            productOrderDetailRepository.save(updatedProductOrder);

            return true;
        } else {
            return false;
        }
    }
}
