package org.gagu.repository;

import org.gagu.entity.ProductionOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionOrderRepository extends JpaRepository<ProductionOrder, String> {
    // 필요한 경우 사용자 정의 쿼리 메서드를 추가하세요
}
