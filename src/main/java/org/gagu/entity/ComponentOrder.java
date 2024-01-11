package org.gagu.entity;

import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "component_id")
    private String componentId;

    @Column(name = "component_order_vendorname")
    private String componentOrderVendorName;

    @Column(name = "component_order_orderform")
    private String componentOrderOrderForm;

    @Column(name = "component_order_orderdate")
    private String componentOrderOrderDate;

    @Column(name = "component_order_deliverydate")
    private Timestamp componentOrderDeliveryDate;

    @Column(name = "component_order_receiptdate")
    private Timestamp componentOrderReceiptDate;

    @Column(name = "component_order_price_amount")
    private Integer componentOrderPriceAmount;

    @Column(name = "component_order_negotiated_amount")
    private Integer componentOrderNegotiatedAmount;

}
