package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.CountryRepository;
import dev.sda.team2.pma.entity.Country;
import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class CountryServiceImpl implements ICountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl (CountryRepository theCountryRepository) {
        countryRepository = theCountryRepository;
    }

    @Override
    public List<Country> findAll() { return countryRepository.findAll(); }

    @Override
    public Country findById(long theId) {

        Optional<Country> result = countryRepository.findById(theId);
        Country theCountry = null;
        if (result.isPresent()){
            theCountry = result.get();
        } else {
            throw new RuntimeException("Did not find country id" + theId);
        }
        return theCountry;
        }

    @Override
    @Transactional
    @Audit(action = "Country saved")
    public void save(Country theCountry) {
        countryRepository.save(theCountry);

    }

    @Override
    @Transactional
    @Audit(action = "Country deleted")
    public void deleteById(long theId) {
        countryRepository.deleteById(theId);

    }
}
