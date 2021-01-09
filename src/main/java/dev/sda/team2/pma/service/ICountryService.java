package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Country;

import java.util.List;

public interface ICountryService {
    List<Country> findAll();
    Country findById(long theId);
    void save(Country theCountry);
    void deleteById(long theId);
}
