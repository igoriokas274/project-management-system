package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.QuotationStatusRepository;
import dev.sda.team2.pma.entity.QuotationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuotationStatusImpl implements IQuotationStatusService {

    private final QuotationStatusRepository quotationStatusRepository;

    @Autowired
    public QuotationStatusImpl (QuotationStatusRepository theQuotationStatusRepository){quotationStatusRepository = theQuotationStatusRepository;}

    @Override
    public List<QuotationStatus> findAll() {return quotationStatusRepository.findAll();}

    @Override
    public QuotationStatus findById(long theId) {

        Optional<QuotationStatus> result = quotationStatusRepository.findById(theId);
        QuotationStatus theQuotationStatus;
        if (result.isPresent()){
            theQuotationStatus = result.get();
        } else {
            throw new RuntimeException("Did not find Quotation status id" + theId);
        }
        return theQuotationStatus;
    }

    @Override
    public void save(QuotationStatus theQuotationStatus){
        quotationStatusRepository.save(theQuotationStatus);
    }

    @Override
    public void deleteById(long theId) {
        quotationStatusRepository.deleteById(theId);
    }
}
