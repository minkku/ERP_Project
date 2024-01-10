package org.gagu.repository.businessPartner;

import org.gagu.dto.business.BusinessPartnerDetailResponse;
import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.entity.businessPartner.BusinessPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PartnerRepository extends JpaRepository<BusinessPartner, Integer>, PartnerCustomRepository {
    @Query("SELECT NEW org.gagu.dto.business.BusinessPartnerResponse(" +
            "b.partnerId, " +
            "b.bpName, " +
            "b.companyNumber, " +
            "b.phone, " +
            "b.address) " +
            "FROM BusinessPartner b " +
            "WHERE b.partnerId = :partnerId")
    BusinessPartnerResponse findBy(@Param("partnerId") int partnerId);

}
