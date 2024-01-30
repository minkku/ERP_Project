package org.gagu.entity.quotation;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import org.gagu.entity.member.Member;
import org.hibernate.annotations.DynamicUpdate;

@NoArgsConstructor
@Getter
@Entity
@DynamicUpdate
@Table(name = "component_quotation")
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_quotation_id")
    private int quotaionId;

    @OneToOne
    @JoinColumn(name = "member_id")
    @PrimaryKeyJoinColumn(name = "member_id")
    private Member memberId;

    @Column(name = "component_quotation_vendorname")
    private String vendorName;

    @Column(name = "component_quotation_quotation")
    private String quotation;

    @Column(name = "component_quotation_quotationdate")
    private Timestamp quotationDate;

    @Column(name = "component_quotation_deliverydate")
    private LocalDateTime deliveryDate;

    @Column(name = "component_quotation_shippingdate")
    private Timestamp shippingDate;

    @Column(name = "component_quotation_price_amount")
    private int priceAmount;

    @Column(name = "component_quotation_note")
    private String note;

    @Builder
    public Quotation(int quotaionId,
                     Member memberId,
                     String vendorName,
                     String quotation,
                     Timestamp quotationDate,
                     LocalDateTime deliveryDate,
                     Timestamp shippingDate,
                     int priceAmount,
                     String note) {
        this.quotaionId = quotaionId;
        this.memberId = memberId;
        this.vendorName = vendorName;
        this.quotation = quotation;
        this.quotationDate = quotationDate;
        this.deliveryDate = deliveryDate;
        this.shippingDate = shippingDate;
        this.priceAmount = priceAmount;
        this.note = note;
    }
}
