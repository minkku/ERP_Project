package org.gagu.repository;

import org.gagu.entity.ComponentQuotation;
import org.gagu.entity.ComponentQuotationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentQuotationRepository extends JpaRepository<ComponentQuotation, Integer> {
    List<ComponentQuotationItem> findBycomponentQuotationId(int componentQuotationId);

    // 직접 SQL을 작성한 예제
    //@Query("SELECT m FROM Member m WHERE m.name = ?1")
    //List<component-quotationItem> findBycomponent-quotationId(int component-quotationId);

}
