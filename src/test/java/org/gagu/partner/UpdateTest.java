package org.gagu.partner;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.business.BusinessPartnerResponse;
import org.gagu.entity.businessPartner.BusinessPartner;
import org.gagu.repository.businessPartner.PartnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class UpdateTest {
    private final PartnerRepository partnerRepository;
    @Test
    public void testSelect(){
        int partnerId = 2;
        Optional<BusinessPartnerResponse> result = partnerRepository.findById(partnerId);
        System.out.println("=============================");
        if(result.isPresent()){
            Member member = result.get();
            System.out.println(member);
        }
    }

    @Test
    @Transactional
    public void updateList() {
        BusinessPartner b = new BusinessPartner();


    }
}
