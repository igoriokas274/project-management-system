package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Currency;

import java.util.List;

public interface ICurrencyService {

    List<Currency> findAll();

    Currency findById(long theId);

    void save(Currency theCurrency);
    void deleteById(long theId);
}
