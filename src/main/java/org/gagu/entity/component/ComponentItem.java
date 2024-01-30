package org.gagu.entity.component;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gagu.entity.Component;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@NoArgsConstructor
@Getter
@DynamicUpdate
@Table(name = "component_order_item")
public class ComponentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_order_item_id", updatable = false)
    private int componentOrderItemId;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private Component componentId;

    @Column(name = "component_order_id")
    private int componentOrderId;

    @Column(name = "component_order_item_quantity")
    private int quantity;

    @Column(name = "component_order_item_price")
    private int price;

    @Column(name = "component_order_item_detail")
    private String detail;

    @Builder
    public ComponentItem(int componentOrderItemId,
                         Component componentId,
                         int componentOrderId,
                         int quantity,
                         int price,
                         String detail) {
        this.componentOrderItemId = componentOrderItemId;
        this.componentId = componentId;
        this.componentOrderId = componentOrderId;
        this.quantity = quantity;
        this.price = price;
        this.detail = detail;
    }
}
