package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.QuotationStatusRepository;
import dev.sda.team2.pma.entity.QuotationStatus;
import dev.sda.team2.pma.service.IQuotationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quotationstatuses")
public class QuotationStatusRestController {

    private IQuotationStatusService quotationStatusService;

    @Autowired
    private QuotationStatusRepository quotationStatusRepository;

    public QuotationStatusRestController(IQuotationStatusService theQuotationStatusService) {
        quotationStatusService = theQuotationStatusService;
    }

    @GetMapping("/list")
    public List<QuotationStatus> listQuotationsStatuses() {

        return quotationStatusService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<QuotationStatus> showQuotationStatusId(@PathVariable("id") long theId) {

        return quotationStatusRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteQuotationStatusById(@PathVariable("id") long theId) {

        quotationStatusService.deleteById(theId);
    }

}
