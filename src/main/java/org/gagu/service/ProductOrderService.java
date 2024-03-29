package org.gagu.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gagu.dto.ProductOrderInfoDataDTO;
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

    public List<ProductOrderListDTO> getProductOrderCheckoutList(Pageable pageable) {
        return productOrderRepository.findProductOrderCheckoutList(pageable);
    }

    public List<ProductOrderListDTO> getProductOrderAllList(Pageable pageable) {
        return productOrderRepository.findProductOrderAllList(pageable);
    }

    public List<ProductOrderListDTO> getProductSalesList(Pageable pageable) {
        return productOrderRepository.findProductSalesList(pageable);
    }

    public long getProductOrderListCount() {
        return productOrderRepository.findProductOrderListCount();
    }

    public long getProductOrderCheckoutListCount() {
        return productOrderRepository.findProductOrderCheckoutListCount();
    }
    public long getProductOrderAllListCount() {
        return productOrderRepository.findProductOrderAllListCount();
    }

    public long getProductSalesCount() {
        return productOrderRepository.findProductSalesListCount();
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
