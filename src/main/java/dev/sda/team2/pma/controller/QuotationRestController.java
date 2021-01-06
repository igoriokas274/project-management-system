package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.QuotationRepository;
import dev.sda.team2.pma.entity.Quotation;
import dev.sda.team2.pma.service.IQuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quotations")
public class QuotationRestController {

    private IQuotationService quotationService;

    @Autowired
    private QuotationRepository quotationRepository;

    public QuotationRestController(IQuotationService theQuotationService) {
        quotationService = theQuotationService;
    }

    @GetMapping("/list")
    public List<Quotation> listQuotations() {

        return quotationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Quotation> showQuotationById(@PathVariable("id") long theId) {

        return quotationRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteQuotationById(@PathVariable("id") long theId) {

        quotationService.deleteById(theId);
    }
}
