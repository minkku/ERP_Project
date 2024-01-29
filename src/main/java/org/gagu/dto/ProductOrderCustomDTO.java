package org.gagu.dto;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Builder
@RequiredArgsConstructor
public class ProductOrderCustomDTO {
    private String productOrderNumber; // 발주번호
    private String memberName; // 발주담당자
    private Timestamp productOrderOrderdate; // 발주요청일
    private Timestamp productOrderDeliverydate; // 납기일
    private String businessvenderCompanynumber;
    private String businessvenderName; // 거래처명
    private String businessvenderAddress;
    private String businessvenderSmalltype;
    private String businessvenderBigtype;
    private String businessvenderRepresentativename;
    private String businessvenderPhone;
    private String productOrderItemDetail;
    private Integer productOrderPriceAmount; // 부가세포함 합계금액

    public ProductOrderCustomDTO(String productOrderNumber,
                                String memberName,
                                Timestamp productOrderOrderdate,
                                Timestamp productOrderDeliverydate,
                                String businessvenderCompanynumber,
                                String businessvenderName,
                                String businessvenderAddress,
                                String businessvenderBigtype,
                                String businessvenderSmalltype,
                                String businessvenderRepresentativename,
                                String businessvenderPhone,
                                String productOrderItemDetail,
                                Integer productOrderPriceAmount) {
        this.productOrderNumber = productOrderNumber;
        this.memberName = memberName;
        this.productOrderOrderdate = productOrderOrderdate;
        this.productOrderDeliverydate = productOrderDeliverydate;
        this.businessvenderCompanynumber = businessvenderCompanynumber;
        this.businessvenderName = businessvenderName;
        this.businessvenderAddress = businessvenderAddress;
        this.businessvenderBigtype = businessvenderBigtype;
        this.businessvenderSmalltype = businessvenderSmalltype;
        this.businessvenderRepresentativename = businessvenderRepresentativename;
        this.businessvenderPhone = businessvenderPhone;
        this.productOrderItemDetail = productOrderItemDetail;
        this.productOrderPriceAmount = productOrderPriceAmount;
    }
}