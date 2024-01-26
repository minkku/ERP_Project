package org.gagu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReturnProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_product_id") //반품상품 인덱스
    private int returnProductId;

    @Column(name = "return_product_price") // 반품 상품 단가
    private int returnProductPrice;

    @Column(name = "return_product_date") //반품 상품 발생일
    private int returnProductDate;

    @Column(name = "return_product_shippingdate") //반품상품 출하 날자
    private int returnProductShippingdate;

    @Column(name = "return_product_price_amount") //반품 상품 총액
    private int returnProductPriceAmount;


}
