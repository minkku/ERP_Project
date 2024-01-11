package org.gagu.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "businessvender")
public class BusinessVender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "businessvender_id")
    private Integer businessvenderId;

    @Column(name = "businessvender_name")
    private String businessvenderName;

    @Column(name = "businessvender_companynumber")
    private String businessvenderCompanynumber;

    @Column(name = "businessvender_phone")
    private String businessvenderPhone;

    @Column(name = "businessvender_fax")
    private String businessvenderFax;

    @Column(name = "businessvender_address")
    private String businessvenderAddress;

    @Column(name = "businessvender_representativename")
    private String businessvenderRepresentativename;

    @Column(name = "businessvender_type")
    private String businessvenderType;

    @Column(name = "businessvender_note")
    private String businessvenderNote;

    @Column(name = "businessvender_bigtype")
    private String businessvenderBigtype;

    @Column(name = "businessvender_smalltype")
    private String businessvenderSmalltype;
}
