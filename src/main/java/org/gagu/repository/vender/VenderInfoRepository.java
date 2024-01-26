package org.gagu.repository.vender;

import org.gagu.entity.vender.Vender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VenderInfoRepository extends JpaRepository<Vender, Integer> {
    @Query("SELECT v " +
            "FROM " +
            "Vender v " +
            "WHERE v.venderId = :venderId")
    Vender findByVenderId(int venderId);
}
