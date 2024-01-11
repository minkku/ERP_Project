package org.gagu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_specification")
    private String productSpecification;

    @Column(name = "product_material")
    private String productMaterial;

    @Column(name = "product_type")
    private Integer productType;

    @Column(name = "product_retailprice")
    private Integer productRetailprice;

    @Column(name = "product_costprice")
    private Integer productCostprice;

    @Column(name = "product_sellingprice")
    private Integer productSellingprice;

    @Column(name = "product_img")
    private String productImg;

    @Column(name = "product_productionperiod")
    private String productProductionperiod;
}