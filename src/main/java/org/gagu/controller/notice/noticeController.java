package org.gagu.controller.notice;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.entity.notice.Notice;
import org.gagu.service.notice.NoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class noticeController {
    private final NoticeService noticeService;

    @GetMapping("/")
    public String getList(Model model,
                          @PageableDefault(size = 10) Pageable pageable) {
        Page<Notice> getList = noticeService.findAll(pageable);

        model.addAttribute("list", getList);

        return "index";
    }
}
