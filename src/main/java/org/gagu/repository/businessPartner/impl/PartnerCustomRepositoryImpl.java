package org.gagu.repository.businessPartner.impl;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.entity.businessPartner.QBusinessPartner;
import org.gagu.repository.businessPartner.PartnerCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
@RequiredArgsConstructor
@Repository
public class PartnerCustomRepositoryImpl implements PartnerCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<BusinessPartnerResponse> getPartnerList(int size, int page) {
        QBusinessPartner qBp = QBusinessPartner.businessPartner;

        QueryResults<BusinessPartnerResponse> results = jpaQueryFactory
                .select(Projections.constructor(
                        BusinessPartnerResponse.class,
                        qBp.partnerId,
                        qBp.bpName,
                        qBp.companyNumber,
                        qBp.phone,
                        qBp.address
                ))
                .from(qBp)
                .offset(size * page)
                .limit(size)
                .fetchResults();
        // change result into instance
        List<BusinessPartnerResponse> content = results.getResults();
        long total = results.getTotal();
        PageRequest pageRequest = PageRequest.of(page, size);
        return new PageImpl<>(content, pageRequest, total);
    }
}
