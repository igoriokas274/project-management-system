package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.CurrencyRepository;
import dev.sda.team2.pma.entity.Currency;
import dev.sda.team2.pma.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyRestController {

    private ICurrencyService currencyService;

    @Autowired
    private CurrencyRepository currencyRepository;

    public CurrencyRestController(ICurrencyService theCountryService) {
        currencyService = theCountryService;
    }

    @GetMapping("/list")
    public List<Currency> listCurrencies() {

        return currencyService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Currency> showCurrencyId(@PathVariable("id") long theId) {

        return currencyRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteCurrencyById(@PathVariable("id") long theId) {

        currencyService.deleteById(theId);
    }

}
