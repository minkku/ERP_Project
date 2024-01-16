package org.gagu.repository;

import org.gagu.entity.ComponentOrderItem;
import org.gagu.entity.ComponentReceivingManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentReceivingManagementRepository extends JpaRepository<ComponentReceivingManagement, Integer> {
    List<ComponentOrderItem> findBycomponentReceivingId(int componentReceivingId);

    // 직접 SQL을 작성한 예제
    //@Query("SELECT m FROM Member m WHERE m.name = ?1")
    //List<component-quotationItem> findBycomponent-quotationId(int component-quotationId);

}
