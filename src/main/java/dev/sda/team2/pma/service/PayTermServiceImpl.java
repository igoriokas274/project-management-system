package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.PayTermRepository;
import dev.sda.team2.pma.entity.PayTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PayTermServiceImpl implements IPayTermService {

    private PayTermRepository payTermRepository;

    @Autowired
    public PayTermServiceImpl(PayTermRepository thePayTermRepository) {
        payTermRepository = thePayTermRepository;
    }

    @Override
    public List<PayTerm> findAll() {
        return payTermRepository.findAll();
    }


    @Override
    public void save(PayTerm thePayTerm) {
        payTermRepository.save(thePayTerm);
    }

    @Override
    public void deleteBy(BigDecimal theId) {
        payTermRepository.deleteById(theId);
    }

}

