package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.PayTermRepository;
import dev.sda.team2.pma.entity.PayTerm;
import dev.sda.team2.pma.service.IPayTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payterms")
public class PayTermRestController {

    private IPayTermService payTermService;

    @Autowired
    private PayTermRepository payTermRepository;

    public PayTermRestController(IPayTermService thePayTermService) {
        payTermService = thePayTermService;
    }

    @GetMapping("/list")
    public List<PayTerm> listPayTerms() {

        return payTermService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PayTerm> showPayTermId(@PathVariable("id") BigDecimal theId) {

        return payTermRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deletePayTermById(@PathVariable("id") BigDecimal theId) {

      payTermService.deleteBy(theId);
    }

}
