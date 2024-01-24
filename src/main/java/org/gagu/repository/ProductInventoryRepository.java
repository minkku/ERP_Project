package org.gagu.repository;

import org.gagu.entity.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInventoryRepository extends JpaRepository<org.gagu.entity.ProductInventory, Integer> {
    @Query("SELECT pi " +
             "FROM ProductInventory pi " +
            "WHERE pi.productId = :productId")
    public ProductInventory findProductInventoryByProductId(String productId);
}
