package org.gagu.dto.sale;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Builder
@RequiredArgsConstructor
public class ProductOrderListDTO {
    private String productOrderNumber; // 발주번호
    private Timestamp productOrderOrderdate; // 발주요청일
    private String businessvenderName; // 거래처명
    private String productName; // 품목첫번째이름
    private Integer productOrderItemQuantity; // 품목수(품목(외))
    private Integer productOrderPriceAmount; // 부가세포함 합계금액
    private Integer productOrderStatus; // 상태
    private Integer productOrderId; // 조회하기위한 product_order_id

    public ProductOrderListDTO(String productOrderNumber, Timestamp productOrderOrderdate, String businessvenderName,
                               String productName, Integer productOrderItemQuantity, Integer productOrderPriceAmount,
                               Integer productOrderStatus, Integer productOrderId) {
        this.productOrderNumber = productOrderNumber;
        this.productOrderOrderdate = productOrderOrderdate;
        this.businessvenderName = businessvenderName;
        this.productName = productName;
        this.productOrderItemQuantity = productOrderItemQuantity;
        this.productOrderPriceAmount = productOrderPriceAmount;
        this.productOrderStatus = productOrderStatus;
        this.productOrderId = productOrderId;
    }
}