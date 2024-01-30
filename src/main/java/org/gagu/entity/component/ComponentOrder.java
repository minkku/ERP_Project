package org.gagu.entity.component;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gagu.entity.Component;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;
@Entity
@NoArgsConstructor
@Getter
@DynamicUpdate
@Table(name = "component_order")
public class ComponentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_order_id", nullable = false)
    private int componentOrderId;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private Component componentId;

    @Column(name = "component_order_vendorname")
    private String vendorName;

    @Column(name = "component_order_orderform")
    private String orderForm;

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

    @Builder
    public ComponentOrder(int componentOrderId,
                          Component componentId,
                          String vendorName,
                          String orderForm,
                          Timestamp orderDate,
                          Timestamp deliveryDate,
                          Timestamp receiptDate,
                          int amount,
                          int negoAmount) {
        this.componentOrderId = componentOrderId;
        this.componentId = componentId;
        this.vendorName = vendorName;
        this.orderForm = orderForm;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.receiptDate = receiptDate;
        this.amount = amount;
        this.negoAmount = negoAmount;
    }
}
