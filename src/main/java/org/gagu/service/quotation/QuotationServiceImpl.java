package org.gagu.service.quotation;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.entity.quotation.Quotation;
import org.gagu.repository.quotation.QuotationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class QuotationServiceImpl implements QuotationService{
    private final QuotationRepository quotationRepository;

    @Override
    public Page<Quotation> findAll(Pageable pageable) {
        return quotationRepository.findAll(pageable);
    }
}
