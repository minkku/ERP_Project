package org.gagu.repository;

import org.gagu.entity.ComponentOrder;
import org.gagu.entity.ComponentOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentOrderRepository extends JpaRepository<ComponentOrder, Integer> {
    List<ComponentOrderItem> findByComponentOrderId(int componentOrderId);

    // 직접 SQL을 작성한 예제
    //@Query("SELECT m FROM Member m WHERE m.name = ?1")
    //List<ComponentOrderItem> findByComponentOrderId(int componentOrderId);

}
