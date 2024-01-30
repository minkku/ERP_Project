package org.gagu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "component")
public class Component {

    @Id
    @Column(name = "component_id")
    private String componentId;

    @Column(name = "component_name")
    private String componentName;

    @Column(name = "component_material")
    private String componentMaterial;

    @Column(name = "component_purchasecost", columnDefinition = "INTEGER")
    private Integer componentPurchasecost;
}
