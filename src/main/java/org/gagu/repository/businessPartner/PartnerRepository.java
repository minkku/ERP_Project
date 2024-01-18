package org.gagu.repository.businessPartner;

import org.gagu.dto.business.BusinessPartnerDetailResponse;
import org.gagu.dto.business.BusinessPartnerResponse;
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
    @Query("UPDATE " +
                "BusinessPartner bp " +
            "SET " +
                "bp.bpName = :bpName, " +
                "bp.companyNumber = :companyNumber, " +
                "bp.phone = :phone, " +
                "bp.fax = :fax, " +
                "bp.address = :address, " +
                "bp.headName = :headName, " +
                "bp.type = :type, " +
                "bp.note = :note, " +
                "bp.bigType = :bigType, " +
                "bp.smallType = :smallType " +
            "WHERE " +
                "bp.partnerId = :partnerId")
    int updatePartnerById(@Param("partnerId") int partnerId);
}
