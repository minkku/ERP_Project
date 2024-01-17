package org.gagu.repository;

import org.gagu.entity.Product;
import org.gagu.entity.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Integer> {

    List<Product> findByProductProductName(String productName);
}
