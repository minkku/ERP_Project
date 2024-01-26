
package org.gagu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductionOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_order_id") //생산 인덱스
    private int productionOrderId;

    @Column(name = "production_id") // 생산 코드
    private String productionId;

    @Column(name = "product_necessarycomponent_id") //부품 필요코드
    private String productNecessarycomponentId;

    @Column(name = "production_quantity") //생산 수량
    private String productionQuantity;

    @Column(name = "production_orderdate") //생산 발주일
    private Timestamp productionOrderdate;

    @Column(name = "production_order_deliverydate") //생산 납기일
    private Timestamp productionOrderDeliverydate;

    @Column(name = "production_order_updatedate") //생산 수정일
    private Timestamp productionOrderUpdatedate;

    @Column(name = "production_status") //생산 상태
    private String productionStatus;
    
}
