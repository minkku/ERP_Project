package org.gagu.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "product_necessarycomponent")
public class ProductNecessarycomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_necessarycomponent_id")
    private Integer productNecessarycomponentId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "component_id")
    private String componentId;

    @Column(name = "product_necessarycomponent_amount")
    private Integer productNecessarycomponentAmount;
}
