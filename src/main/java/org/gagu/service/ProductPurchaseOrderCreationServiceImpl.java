package org.gagu.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gagu.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductPurchaseOrderCreationServiceImpl implements ProductPurchaseOrderCreationService{
    @Autowired
    ProductOrderRepository productOrderRepository;
    @Override
    public String newPOCode() {
        int maxAttempts = 1000;
        String[] num = { "0", "1", "2", "3", "4", "5", "6",
                "7", "8", "9" };

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            StringBuilder orderNum = new StringBuilder();
            orderNum.append("PO");
            for (int i = 0; i < 8; i++) {
                int ran = new Random().nextInt(num.length);
                orderNum.append(num[ran]);
            }

            if (productOrderRepository.findByProductOrderNumber(orderNum.toString()) < 1) {
                System.out.println(orderNum);
                return orderNum.toString();
            }
        }
        throw new RuntimeException("Failed to generate a unique orders number after " + maxAttempts + " attempts.");
    }
}
