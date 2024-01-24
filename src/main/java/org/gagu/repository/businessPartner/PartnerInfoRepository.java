package org.gagu.repository.businessPartner;

import org.gagu.entity.businessPartner.BusinessPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PartnerInfoRepository extends JpaRepository<BusinessPartner, Integer> {
    @Query("SELECT b " +
            "FROM " +
            "BusinessPartner b " +
            "WHERE b.partnerId = :partnerId")
    BusinessPartner findByPartnerId(int partnerId);
}
