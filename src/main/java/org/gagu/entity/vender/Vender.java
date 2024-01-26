package org.gagu.entity.vender;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@NoArgsConstructor
@Getter
@DynamicUpdate
@Table(name = "businessvender")
public class Vender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "businessvender_id", nullable = false)
    private int venderId;

    @Column(name = "businessvender_name")
    private String venderName;

    @Column(name = "businessvender_companynumber")
    private String companyNum;

    @Column(name = "businessvender_phone")
    private String phone;

    @Column(name = "businessvender_fax")
    private String fax;

    @Column(name = "businessvender_address")
    private String address;

    @Column(name = "businessvender_representativename")
    private String headName;

    @Column(name = "businessvender_type")
    private String type;

    @Column(name = "businessvender_note")
    private String note;

    @Column(name = "businessvender_bigtype")
    private String bigType;

    @Column(name = "businessvender_smalltype")
    private String smallType;

    @Builder
    public Vender(int venderId,
                  String venderName,
                  String companyNum,
                  String phone,
                  String fax,
                  String address,
                  String headName,
                  String type,
                  String note,
                  String bigType,
                  String smallType) {
        this.venderId = venderId;
        this.venderName = venderName;
        this.companyNum = companyNum;
        this.phone =phone;
        this.fax = fax;
        this.address = address;
        this.headName = headName;
        this.type = type;
        this.note = note;
        this.bigType = bigType;
        this.smallType = smallType;
    }
}