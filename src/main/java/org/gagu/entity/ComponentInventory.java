package org.gagu.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "component_inventory")
public class ComponentInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_inventory_id")
    private Integer componentInventoryId;

    @Column(name = "component_id")
    private String componentId;

    @Column(name = "component_name")
    private String componentName;

    @Column(name = "component_inventory_quantity")
    private Integer componentInventoryQuantity;

    @Column(name = "component_stock")
    private Integer componentStock;
}
