package org.gagu.repository.vender;

import org.gagu.entity.vender.Vender;
import org.springframework.data.domain.Page;

public interface VenderCustomRepository {
    Page<Vender> getVenderList(int size, int page);
}
