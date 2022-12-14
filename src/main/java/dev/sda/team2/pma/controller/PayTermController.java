package dev.sda.team2.pma.controller;


import dev.sda.team2.pma.dao.PayTermRepository;
import dev.sda.team2.pma.entity.PayTerm;
import dev.sda.team2.pma.service.IPayTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/settings/payterms")
public class PayTermController {

    private IPayTermService payTermService;

    @Autowired
    private PayTermRepository payTermRepository;

    @Autowired
    public PayTermController(IPayTermService thePayTermService){payTermService = thePayTermService;}

    @GetMapping("/list")
    public String listPayTerms(Model theModel) {

        List<PayTerm> thePayTerms = payTermService.findAll();
        theModel.addAttribute("payTerms", thePayTerms);

        Object payTerm = new PayTerm();
        theModel.addAttribute("payTerm", payTerm);

        return "settings/list-payterms";
    }

    @PostMapping("/save")
    public String savePayTerm(PayTerm thePayTerm) {

        payTermService.save(thePayTerm);
        return "redirect:/settings/payterms/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<PayTerm> editPayTerm(@RequestParam("id") Long theId) {

        return payTermRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deletePayTerm(@RequestParam("id") Long theId) {

        payTermService.deleteById( theId );
        return "redirect:/settings/payterms/list";
    }
}
