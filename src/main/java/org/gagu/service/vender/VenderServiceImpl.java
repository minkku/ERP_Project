package org.gagu.service.vender;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.vender.RegisterVenderResponse;
import org.gagu.dto.vender.VenderResponse;
import org.gagu.entity.vender.Vender;
import org.gagu.repository.vender.VenderRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class VenderServiceImpl implements VenderService{
    private final VenderRepository venderRepository;

    @Override
    public Page<VenderResponse> getVenderList(int size, int page) {
        return venderRepository.getVenderList(size, page);
    }

    @Override
    public Vender registerVender(RegisterVenderResponse response) {
        Vender vender = Vender.builder()
                .venderName(response.getVenderName())
                .companyNum(response.getCompanyNum())
                .phone(response.getPhone())
                .fax(response.getFax())
                .address(response.getAddress())
                .headName(response.getHeadName())
                .type(response.getType())
                .note(response.getNote())
                .bigType(response.getBigType())
                .smallType(response.getSmallType())
                .build();
        return venderRepository.save(vender);
    }
}
