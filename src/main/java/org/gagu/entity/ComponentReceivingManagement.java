package org.gagu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Table(name = "component_receiving")
public class ComponentReceivingManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_receiving_id")
    private Integer componentReceivingId;

    @Column(name = "component_order_id")
    private Integer componentOrderId;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "component_receiving_in_stock")
    private Integer componentReceivingInStock;

    @Column(name = "component_receiving_receiptdate")
    private Timestamp componentReceivingReceiptdate;


}
