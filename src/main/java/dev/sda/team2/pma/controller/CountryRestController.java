package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.CountryRepository;
import dev.sda.team2.pma.entity.Country;
import dev.sda.team2.pma.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {

    private ICountryService countryService;

    @Autowired
    private CountryRepository countryRepository;

    public CountryRestController(ICountryService theCountryService) {
        countryService = theCountryService;
    }

    @GetMapping("/list")
    public List<Country> listCountries() {

        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Country> showCountryId(@PathVariable("id") long theId) {

        return countryRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteCountryById(@PathVariable("id") long theId) {

        countryService.deleteById(theId);
    }

}
