package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.QuotationRepository;
import dev.sda.team2.pma.entity.Quotation;
import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Audit(action = "Quotation saved")
    public void save(Quotation theQuotation) {

        quotationRepository.save(theQuotation);
    }

    @Override
    @Transactional
    @Audit(action = "Quotation deleted")
    public void deleteById(long theId) {

        quotationRepository.deleteById(theId);
    }
}
