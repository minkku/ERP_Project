package org.gagu.entity.component;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;
@Entity
@NoArgsConstructor
@Getter
@DynamicUpdate
@Table(name = "component_order")
public class componentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_order_id", nullable = false)
    private int componentOrderId;

    @Column(name = "component_id")
    private String componentId;

    @Column(name = "component_order_vendorname")
    private String vendorName;

    @Column(name = "component_order_orderform")
    private String orderform;

    @Column(name = "component_order_orderdate")
    private Timestamp orderDate;

    @Column(name = "component_order_deliverydate")
    private Timestamp deliveryDate;

    @Column(name = "component_order_receiptdate")
    private Timestamp receiptDate;

    @Column(name = "component_order_price_amount")
    private int amount;

    @Column(name = "component_order_negotiated_amount")
    private int negoAmount;
}
