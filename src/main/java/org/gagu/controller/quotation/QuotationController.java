package org.gagu.controller.quotation;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.entity.quotation.Quotation;
import org.gagu.service.quotation.QuotationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class QuotationController {
    private final QuotationService quotationService;

    @GetMapping("/quotationList")
    public String getQuotationList(Model model,
                                   @PageableDefault(size = 10) Pageable pageable)
    {
        Page<Quotation> getQuotationList = quotationService.findAll(pageable);

        model.addAttribute("list", getQuotationList);

        return "components-quotations";
    }
}
