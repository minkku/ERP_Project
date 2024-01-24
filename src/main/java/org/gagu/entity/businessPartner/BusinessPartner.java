package org.gagu.entity.businessPartner;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@NoArgsConstructor
@Getter
@DynamicUpdate
@Table(name = "businesspartner")
public class BusinessPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "businesspartner_id", nullable = false)
    private int partnerId;

    @Column(name = "businesspartner_name")
    private String bpName;

    @Column(name = "businesspartner_companynumber")
    private String companyNumber;

    @Column(name = "businesspartner_phone")
    private String phone;

    @Column(name = "businesspartner_fax")
    private String fax;

    @Column(name = "businesspartner_address")
    private String address;

    @Column(name = "businesspartner_representativename")
    private String headName;

    @Column(name = "businesspartner_type")
    private String type;

    @Column(name = "businesspartner_note")
    private String note;

    @Column(name = "businesspartner_bigtype")
    private String bigType;

    @Column(name = "businesspartner_smalltype")
    private String smallType;

    @Builder
    public BusinessPartner(int partnerId,
                           String bpName,
                           String companyNumber,
                           String phone,
                           String fax,
                           String address,
                           String headName,
                           String type,
                           String note,
                           String bigType,
                           String smallType
    ) {
        this.partnerId = partnerId;
        this.bpName = bpName;
        this.companyNumber = companyNumber;
        this.phone = phone;
        this.fax = fax;
        this.address = address;
        this.headName = headName;
        this.type = type;
        this.note = note;
        this.bigType = bigType;
        this.smallType = smallType;
    }
}
