package org.gagu.service.vender;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
    public Page<Vender> getVenderList(int size, int page) {
        return venderRepository.getVenderList(size, page);
    }
}
