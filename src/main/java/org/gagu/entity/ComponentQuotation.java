package org.gagu.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Table(name = "component_quotation")
public class ComponentQuotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_quotation_id")
    private Integer componentQuotationId;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "component_quotation_vendorname")
    private String componentQuotationVendorname;

    @Column(name = "component_quotation_quotation")
    private String componentQuotationQuotation;

    @Column(name = "component_quotation_quotationdate")
    private Timestamp componentQuotationQuotationdate;

    @Column(name = "component_quotation_deliverydate")
    private LocalDateTime componentQuotationDeliverydate;

    @Column(name = "component_quotation_shippingdate")
    private Timestamp componentQuotationShippingdate;

    @Column(name = "component_quotation_price_amount")
    private Integer componentQuotationPriceAmount;

    @Column(name = "component_quotation_note")
    private String componentQuotationNote;

}
