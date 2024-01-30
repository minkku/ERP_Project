package org.gagu.service.quotation;

import org.gagu.entity.quotation.Quotation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuotationService{
    public Page<Quotation> findAll(Pageable pageable);
}
