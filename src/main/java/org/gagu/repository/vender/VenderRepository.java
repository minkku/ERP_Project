package org.gagu.repository.vender;

import org.gagu.dto.vender.VenderResponse;
import org.gagu.entity.vender.Vender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VenderRepository extends JpaRepository<Vender, Integer>, VenderCustomRepository {
    @Query("SELECT NEW org.gagu.dto.vender.VenderResponse(" +
            "v.venderId, " +
            "v.venderName, " +
            "v.companyNum, " +
            "v.phone, " +
            "v.address) " +
            "FROM " +
            "Vender v " )
    VenderResponse findAll(@Param("venderId") int venderId);
}