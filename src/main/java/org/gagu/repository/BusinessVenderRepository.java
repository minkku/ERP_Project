package org.gagu.repository;

import org.gagu.entity.BusinessVender;
import org.gagu.entity.ComponentQuotation;
import org.gagu.entity.ComponentQuotationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessVenderRepository extends JpaRepository<BusinessVender, Integer> {
    @Query("SELECT bv " +
            "FROM BusinessVender bv " +
            "JOIN ProductOrder po ON bv.businessvenderId = po.businessvenderId " +
            "WHERE po.productOrderId = :productOrderId")
    BusinessVender findBusinessVenderByProductOrderId(@Param("productOrderId") Integer productOrderId);
}
