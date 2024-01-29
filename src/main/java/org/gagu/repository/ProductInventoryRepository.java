package org.gagu.repository;

import org.gagu.entity.Product;
import org.gagu.entity.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, String> {

    List<Product> findByProductProductId(String productId);

    Optional<ProductInventory> findById(String productId);
}
