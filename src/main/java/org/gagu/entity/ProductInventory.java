package org.gagu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_inventory_id")
    private int productInventoryId;

    @Column(name = "product_id") //상품 코드
    private String productId;

    @Column(name = "product_name") //상품 이름
    private String productName;

    @Column(name = "product_inventory_quantity")
    private int productInventoryQuantity;
    @Column(name = "product_inventory_stock")
    private int productInventoryStock;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    private Product product;
}
