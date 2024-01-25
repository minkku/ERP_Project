package org.gagu.partner;

import lombok.extern.log4j.Log4j2;
import org.gagu.entity.businessPartner.BusinessPartner;
import org.gagu.repository.businessPartner.PartnerRepository;
import org.gagu.repository.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class partnerTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PartnerRepository partnerRepository;

    @Test
    public void testMemberId() {
        log.info(memberRepository.getClass().getName());
    }

    @Test
    public void insertDumm() {
        BusinessPartner businessPartner = BusinessPartner.builder()
                .bpName("삼성")
                .companyNumber("S224112342")
                .phone("031-243-1344")
                .fax("23-22-1324")
                .address("경기도 수원시 망포동 24번지")
                .headName("이재용")
                .type("부품 제조")
                .note("재용이형 아들로 들어가고싶다")
                .bigType(null)
                .smallType(null)
                .build();
        partnerRepository.save(businessPartner);
    }
}
