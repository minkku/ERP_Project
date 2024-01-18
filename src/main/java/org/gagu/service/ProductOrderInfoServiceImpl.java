package org.gagu.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gagu.entity.ProductOrder;
import org.gagu.repository.ProductOrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductOrderInfoServiceImpl implements ProductOrderInfoService {
    @Autowired
    private final ProductOrderInfoRepository productOrderInfoRepository;


    @Override
    public boolean updateProductOrderStatus(Integer productOrderId, int productOrderStatus) {
        Optional<ProductOrder> optionalProductOrder = productOrderInfoRepository.findById(productOrderId);

        if (optionalProductOrder.isPresent()) {
            ProductOrder productOrder = optionalProductOrder.get();

            ProductOrder updatedProductOrder = productOrder.toBuilder()
                    .productOrderStatus(productOrderStatus)
                    .productOrderModifiedDate(Timestamp.valueOf(LocalDateTime.now())) //이부분
                    .build();

            productOrderInfoRepository.save(updatedProductOrder);

            return true;
        } else {
            return false;
        }
    }
}
