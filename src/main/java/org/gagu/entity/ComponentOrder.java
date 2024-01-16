package org.gagu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Table(name = "component_order")
public class ComponentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_order_id")
    private Integer componentOrderId;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "component_order_vendorname")
    private String componentOrderVendorname;

    @Column(name = "component_order_orderform")
    private String componentOrderOrderform;

    @Column(name = "component_order_orderdate")
    private Timestamp componentOrderOrderdate;

    @Column(name = "component_order_deliverydate")
    private LocalDateTime componentOrderDeliverydate;

    @Column(name = "component_order_receiptdate")
    private Timestamp componentOrderReceiptdate;

    @Column(name = "component_order_price_amount")
    private Integer componentOrderPriceAmount;

    @Column(name = "component_order_negotiated_amount")
    private Integer componentOrderNegotiatedAmount;

}
