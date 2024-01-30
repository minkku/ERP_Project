package org.gagu.repository.component;

import org.gagu.dto.component.ComponentResponse;
import org.gagu.entity.component.ComponentOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ComponentRepository extends JpaRepository<ComponentOrder, Integer>, ComponentCustomRepository {
//    @Query("SELECT NEW org.gagu.dto.component.ComponentResponse(" +
//                "co.componentOrderId, " +
//                "co.componentId.componentId, " +
//                "co.vendorName, " +
//                "co.orderForm, " +
//                "co.orderDate, " +
//                "co.deliveryDate, " +
//                "co.receiptDate, " +
//                "co.amount) " +
//            "FROM " +
//                "ComponentOrder co " +
//            "JOIN Component c ON co.componentId.componentId = c.componentId ")
    Page<ComponentOrder> findAll(Pageable pageable);
}
