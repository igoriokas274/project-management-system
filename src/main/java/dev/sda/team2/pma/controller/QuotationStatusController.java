package dev.sda.team2.pma.controller;


import dev.sda.team2.pma.dao.QuotationStatusRepository;
import dev.sda.team2.pma.entity.QuotationStatus;
import dev.sda.team2.pma.service.IQuotationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/settings/quotationstatuses")
public class QuotationStatusController {

    private IQuotationStatusService quotationStatusService;

    @Autowired
    private QuotationStatusRepository quotationStatusRepository;

    public QuotationStatusController(IQuotationStatusService theQuotationStatusService){quotationStatusService = theQuotationStatusService;}

    @GetMapping("/list")
    public String listQuotationStatuses(Model theModel) {

        List<QuotationStatus> theQuotationStatuses = quotationStatusService.findAll();
        theModel.addAttribute("quotation statuses", theQuotationStatuses);

        Object department = new QuotationStatus();
        theModel.addAttribute("quotation status", theQuotationStatuses);

        return "settings/list-qoutationstatuses";
    }

    @PostMapping("/save")
    public String saveQuotationStatus (QuotationStatus theQuotationStatus) {

        quotationStatusService.save(theQuotationStatus);
        return "redirect:/settings/qoutationstatuses/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<QuotationStatus> editQuotationStatuses(@RequestParam("id") long theId) {

        return quotationStatusRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteQuotationStatus(@RequestParam("id") long theId) {

        quotationStatusService.deleteById(theId);
        return "redirect:/settings/quotationstatuses/list";
    }
}
