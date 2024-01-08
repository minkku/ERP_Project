package org.gagu.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Table(name = "component_order_item")
public class ComponentOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_order_item_id", updatable = false)
    private Integer component_order_item_id;

    @Column(name = "component_id")
    private String component_id;

    @Column(name = "component_order_id")
    private Integer component_order_id;

    @Column(name = "component_order_item_quantity")
    private Integer component_order_item_quantity;

    @Column(name = "component_order_item_price")
    private Integer component_order_item_price;

    @Column(name = "component_order_item_detail")
    private String component_order_item_detail;

}
