package org.gagu.service.notice;

import org.gagu.entity.notice.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeService {
    Page<Notice> findAll(Pageable pageable);
}
