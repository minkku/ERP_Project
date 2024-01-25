package org.gagu.service.sale;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gagu.dto.sale.ProductOrderInfoDataDTO;
import org.gagu.dto.sale.ProductOrderItemListDTO;
import org.gagu.dto.sale.ProductOrderListDTO;
import org.gagu.entity.BusinessVender;
import org.gagu.entity.ProductOrder;
import org.gagu.repository.sale.BusinessVenderRepository;
import org.gagu.repository.sale.ProductOrderRepository;
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

    public BusinessVender getBusinessVenderByProductOrderId(Integer productOrderId) {
        return businessVenderRepository.findBusinessVenderByProductOrderId(productOrderId);
    }

    public List<ProductOrderItemListDTO> getProductOrderItemsByProductOrderId(Integer productOrderId) {
        return productOrderRepository.findProductOrderItemsByProductOrderId(productOrderId);
    }

    public ProductOrder getProductOrderByProductOrderId(Integer productOrderId) {
        return productOrderRepository.findByProductOrderId(productOrderId);
    }

    public ProductOrderInfoDataDTO ProductOrderInfoData(Integer productOrderId) {
        ProductOrder productOrder = productOrderRepository.findByProductOrderId(productOrderId);
        List<ProductOrderItemListDTO> productOrderItems = productOrderRepository.findProductOrderItemsByProductOrderId(productOrderId);
        BusinessVender businessVender = businessVenderRepository.findBusinessVenderByProductOrderId(productOrderId);

        return ProductOrderInfoDataDTO.builder()
                .productOrder(productOrder)
                .productOrderItems(productOrderItems)
                .businessVender(businessVender)
                .build();
    }
}
