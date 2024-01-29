package org.gagu.entity.component;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@NoArgsConstructor
@Getter
@DynamicUpdate
@Table(name = "component_order_item")
public class componentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_order_item_id", updatable = false)
    private int componentOrderItemId;

    @Column(name = "component_id")
    private String componentId;

    @Column(name = "component_order_id")
    private int componentOrderId;

    @Column(name = "component_order_item_quantity")
    private int quantity;

    @Column(name = "component_order_item_price")
    private int price;

    @Column(name = "component_order_item_detail")
    private String detail;
}
