package org.gagu.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Table(name = "component_quotation_item")
public class ComponentQuotationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_quotation_item_id", updatable = false)
    private Integer componentQuotationItemId;

    @Column(name = "component_id")
    private String componentId;

    @Column(name = "component_quotation_id")
    private Integer componentQuotationId;

    @Column(name = "component_quotation_item_quantity")
    private Integer componentQuotationItemQuantity;

    @Column(name = "component_quotation_item_price")
    private Integer componentQuotationItemPrice;

    @Column(name = "component_quotation_item_note")
    private String componentQuotationItemNote;

}
