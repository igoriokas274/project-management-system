package dev.sda.team2.pma.controller;


import dev.sda.team2.pma.dao.CurrencyRepository;
import dev.sda.team2.pma.entity.Currency;
import dev.sda.team2.pma.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/settings/currencies")
public class CurrencyController {

    private ICurrencyService currencyService;

    @Autowired
    private CurrencyRepository currencyRepository;

    public CurrencyController(ICurrencyService theCurrencyService){currencyService = theCurrencyService;}

    @GetMapping("/list")
    public String listCurrencies(Model theModel) {

        List<Currency> theCurrencies = currencyService.findAll();
        theModel.addAttribute("currencies", theCurrencies);

        Object currency = new Currency();
        theModel.addAttribute("currencies", theCurrencies);

        return "settings/list-currencies";
    }

    @PostMapping("/save")
    public String saveCurrency (Currency theCurrency) {

        currencyService.save(theCurrency);
        return "redirect:/settings/currencies/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<Currency> editCurrency(@RequestParam("id") long theId) {

        return currencyRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteCurrency(@RequestParam("id") long theId) {

        currencyService.deleteById(theId);
        return "redirect:/settings/currencies/list";
    }
}
