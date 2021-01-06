package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.QuotationRepository;
import dev.sda.team2.pma.entity.Quotation;
import dev.sda.team2.pma.service.IQuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projectpanel/quotations")
public class QuotationController {

    private IQuotationService quotationService;

    @Autowired
    private QuotationRepository quotationRepository;

    public QuotationController(IQuotationService theQuotationService) {
        quotationService = theQuotationService;
    }

    @GetMapping("/list")
    public String listQuotations(Model theModel) {

        // List quotations
        List<Quotation> theQuotations = quotationService.findAll();
        theModel.addAttribute("quotations", theQuotations);

        // add new quotations
        Quotation theQuotation = new Quotation();
        theModel.addAttribute("quotation", theQuotation);

        return "projects/list-quotations";
    }

    @PostMapping("/save")
    public String saveQuotation(Quotation theQuotation) {

        quotationService.save(theQuotation);
        return "redirect:/projectpanel/quotations/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<Quotation> editQuotation(@RequestParam("id") long theId) {

        return quotationRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteQuotation(@RequestParam("id") long theId) {

        quotationService.deleteById(theId);
        return "redirect:/projectpanel/quotations/list";
    }

}
