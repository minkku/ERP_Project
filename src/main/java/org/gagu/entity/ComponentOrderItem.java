package org.gagu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Table(name = "component_order_item")
public class ComponentOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_order_item_id", updatable = false)
    private Integer componentOrderItemId;

    @Column(name = "component_id")
    private String componentId;

    @Column(name = "component_order_id")
    private Integer componentOrderId;

    @Column(name = "component_order_item_quantity")
    private Integer componentOrderItemQuantity;

    @Column(name = "component_order_item_price")
    private Integer componentOrderItemPrice;

    @Column(name = "component_order_item_detail")
    private String componentOrderItemDetail;

}
