package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.CurrencyRepository;
import dev.sda.team2.pma.entity.Currency;
import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements ICurrencyService{

    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository theCurrencyRepository) {
        currencyRepository = theCurrencyRepository;
    }

    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency findById(long theId) {

        Optional<Currency> result = currencyRepository.findById(theId);
        Currency theCurrency;
        if (result.isPresent()) theCurrency = result.get();
        else {
            throw new RuntimeException("Did not find currency id" + theId);
        }
        return theCurrency;
    }

    @Override
    @Audit(action = "Currency saved")
    public void save(Currency theCurrency) {
        currencyRepository.save(theCurrency);
    }

    @Override
    @Audit(action = "Currency deleted")
    public void deleteById(long theId) {
        currencyRepository.deleteById(theId);
    }
}
