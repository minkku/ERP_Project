package org.gagu.service;
import org.gagu.entity.Product;
import org.gagu.entity.ProductInventory;
import org.gagu.repository.ProductInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInventoryService {

    private final ProductInventoryRepository productInventoryRepository;

    @Autowired
    public ProductInventoryService(ProductInventoryRepository productInventoryRepository) {
        this.productInventoryRepository = productInventoryRepository;
    }

    public List<Product> getProductsByProductId(String productId) {
        // ProductInventoryRepository에서 productName을 기준으로 Product 엔티티 리스트 가져오기
        return productInventoryRepository.findByProductProductId(productId);
    }
    public List<ProductInventory> getAllProductInventories() {
        List<ProductInventory> productInventories = productInventoryRepository.findAll();
        // Fetch products for each inventory item
        productInventories.forEach(productInventory -> {
            Product product = productInventory.getProduct();
            // Ensure the product details are loaded
            product.getProductId(); // Access any field to trigger lazy loading if necessary
        });
        return productInventories;

    }

    public Product getProductDetailsById(String productId) {
        // ProductInventoryRepository에서 productId를 기준으로 Product 엔티티 가져오기
        Optional<ProductInventory> productInventoryOptional = productInventoryRepository.findById(productId);
        return productInventoryOptional.map(ProductInventory::getProduct).orElse(null);
    }


}