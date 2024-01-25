package org.gagu.repository.businessPartner;

import org.gagu.dto.business.BusinessPartnerDetailResponse;
import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.dto.business.UpdateRequest;
import org.gagu.entity.businessPartner.BusinessPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PartnerRepository extends JpaRepository<BusinessPartner, Integer>, PartnerCustomRepository {
    @Query("SELECT NEW org.gagu.dto.business.BusinessPartnerResponse(" +
                "b.partnerId, " +
                "b.bpName, " +
                "b.companyNumber, " +
                "b.phone, " +
                "b.address) " +
            "FROM BusinessPartner b ")
    BusinessPartnerResponse findAll(@Param("partnerId") int partnerId);
    @Modifying(clearAutomatically = true)
    @Query("UPDATE BusinessPartner bp SET " +
            "bp.bpName = :#{#request.bpName}, " +
            "bp.companyNumber = :#{#request.companyNumber}, " +
            "bp.phone = :#{#request.phone}, " +
            "bp.fax = :#{#request.fax}, " +
            "bp.address = :#{#request.address}, " +
            "bp.headName = :#{#request.headName}, " +
            "bp.type = :#{#request.type}, " +
            "bp.note = :#{#request.note}, " +
            "bp.bigType = :#{#request.bigType}, " +
            "bp.smallType = :#{#request.smallType} " +
            "WHERE bp.partnerId = :partnerId")
            void updatePartner(@Param("partnerId") int partnerId, @Param("request") UpdateRequest request);
}
