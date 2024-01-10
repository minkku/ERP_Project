package org.gagu.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductOrderListDTO {
    private String productOrderNumber; // 발주번호
    private Date productOrderOrderdate; // 발주요청일
    private String businessvenderName; // 거래처명
    private String productName; // 품목첫번째이름
    private Integer productOrderItemQuantity; // 품목수(품목(외))
    private Integer productOrderPriceAmount; // 부가세포함 합계금액
    private String productOrderStatus; // 상태
    private Integer productOrderId; // 조회하기위한 product_order_id
}