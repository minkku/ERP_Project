package org.gagu.repository.quotation;

import org.gagu.entity.quotation.Quotation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepository extends JpaRepository<Quotation, Integer> {
    Page<Quotation> findAll(Pageable pageable);
}
