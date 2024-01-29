package org.gagu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id") //상품 코드
    private String productId;

    @Column(name = "product_name") //상품 이름
    private String productName;
    @Column(name = "product_specification")//규격
    private String productSpecification;
    @Column(name = "product_material")//재질
    private String productMaterial;
    @Column(name = "product_type")//종류
    private Integer  productType;
    @Column(name = "product_retailprice")//소비자 정가
    private Integer  productRetailprice;
    @Column(name = "product_costprice")//생산원가
    private Integer  productCostprice;
    @Column(name = "product_sellingprice")//판매가
    private Integer  productSellingprice;
    @Column(name = "product_img")//이미지
    private String productImg;
    @Column(name = "product_productionperiod")//평균생산 기간
    private String productProductionperiod;

}
