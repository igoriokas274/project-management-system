package dev.sda.team2.pma.controller;


import dev.sda.team2.pma.dao.CountryRepository;
import dev.sda.team2.pma.entity.Country;
import dev.sda.team2.pma.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/settings/countries")
public class CountryController {

    private ICountryService countryService;

    @Autowired
    private CountryRepository countryRepository;

    public CountryController (ICountryService theCountryService){countryService = theCountryService;}

    @GetMapping("/list")
    public String listCountries(Model theModel) {

        // List countries
        List<Country> theCountries = countryService.findAll();
        theModel.addAttribute("countries", theCountries);

        // add new country
        Object theCountry = new Country();
        theModel.addAttribute("country", theCountry);

        return "settings/list-countries";
    }

    @PostMapping("/save")
    public String saveCountry(Country theCountry) {

        countryService.save(theCountry);
        return "redirect:/settings/countries/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<Country> editCountry(@RequestParam("id") long theId) {

        return countryRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteCountry(@RequestParam("id") long theId) {

        countryService.deleteById(theId);
        return "redirect:/settings/countries/list";
    }
}
