package org.gagu.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "product_order")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_order_id")
    private Integer productOrderId;

    @Column(name = "product_order_number")
    private String productOrderNumber;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "businessvender_id")
    private Integer businessvenderId;

    @Column(name = "product_order_orderform")
    private String productOrderOrderform;

    @Column(name = "product_order_orderdate")
    private Timestamp productOrderOrderdate;

    @Column(name = "product_order_deliverydate")
    private Timestamp productOrderDeliverydate;

    @Column(name = "product_order_modified_date")
    private Timestamp productOrderModifiedDate;

    @Column(name = "product_order_status")
    private Integer productOrderStatus;

    @Column(name = "product_order_price_amount")
    private Integer productOrderPriceAmount;

    @Column(name = "product_order_item_detail")
    private String productOrderItemDetail;
}
