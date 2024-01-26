package org.gagu.repository.vender;

import org.gagu.dto.vender.VenderResponse;
import org.springframework.data.domain.Page;

public interface VenderCustomRepository {
    Page<VenderResponse> getVenderList(int size, int page);
}