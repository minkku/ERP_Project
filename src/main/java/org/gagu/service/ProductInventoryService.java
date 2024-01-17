package org.gagu.service;
import org.gagu.entity.Product;
import org.gagu.entity.ProductInventory;
import org.gagu.repository.ProductInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInventoryService {

    private final ProductInventoryRepository productInventoryRepository;

    @Autowired
    public ProductInventoryService(ProductInventoryRepository productInventoryRepository) {
        this.productInventoryRepository = productInventoryRepository;
    }

    public List<Product> getProductsByProductName(String productName) {
        // ProductInventoryRepository에서 productName을 기준으로 Product 엔티티 리스트 가져오기
        return productInventoryRepository.findByProductProductName(productName);
    }
    public List<ProductInventory> getAllProductInventories() {
        return productInventoryRepository.findAll();
    }


}