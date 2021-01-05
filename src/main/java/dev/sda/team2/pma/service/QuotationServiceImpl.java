package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.QuotationRepository;
import dev.sda.team2.pma.entity.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationServiceImpl implements IQuotationService{

    private QuotationRepository quotationRepository;

    @Autowired
    public QuotationServiceImpl(QuotationRepository theQuotationRepository) {
        quotationRepository = theQuotationRepository;
    }

    @Override
    public List<Quotation> findAll() {

        return quotationRepository.findAll();
    }

    @Override
    public void save(Quotation theQuotation) {

        quotationRepository.save(theQuotation);
    }

    @Override
    public void deleteById(long theId) {

        quotationRepository.deleteById(theId);
    }
}
