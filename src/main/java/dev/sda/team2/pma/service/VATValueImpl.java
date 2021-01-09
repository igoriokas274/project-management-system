package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.VATValueRepository;
import dev.sda.team2.pma.entity.VATValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VATValueImpl implements IVATValueService {

    private final VATValueRepository vatValueRepository;

    @Autowired
    public VATValueImpl (VATValueRepository theVATValueRepository){vatValueRepository = theVATValueRepository;}

    @Override
    public List<VATValue> findAll(){return vatValueRepository.findAll();}

    @Override
    public VATValue findById(long theId) {

        Optional<VATValue> result = vatValueRepository.findById(theId);
        VATValue theVATValue;
        if (result.isPresent()){
            theVATValue = result.get();
        } else {
            throw new RuntimeException("Did not find VAT value id" + theId);
        }
        return theVATValue;
    }

    @Override
    public void save (VATValue theVATValue){vatValueRepository.save(theVATValue);}

    @Override
    public void deleteById(long theId) {
        vatValueRepository.deleteById(theId);
    }
}
