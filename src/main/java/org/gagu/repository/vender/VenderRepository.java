package org.gagu.repository.vender;

import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.entity.vender.Vender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VenderRepository extends JpaRepository<Vender, Integer>, VenderCustomRepository {
    @Query("SELECT " +
                "v.venderId, " +
                "v.venderName, " +
                "v.companyNum, " +
                "v.phone, " +
                "v.address " +
            "FROM " +
                "Vender v " )
    Vender findAll(@Param("venderId") int venderId);
}
