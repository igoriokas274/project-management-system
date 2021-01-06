package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.ItemToQuotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemToQuotationServiceImpl implements IItemToQuotationService{

    private IItemToQuotationService iItemToQuotationService;

    @Autowired
    public ItemToQuotationServiceImpl(IItemToQuotationService theIItemToQuotationService) {
        iItemToQuotationService = theIItemToQuotationService;
    }

    @Override
    public List<ItemToQuotation> findAll() {
        return iItemToQuotationService.findAll();
    }

    @Override
    public void save(ItemToQuotation theItemToQuotation) {
        iItemToQuotationService.save(theItemToQuotation);
    }

    @Override
    public void deleteById(long theId) {
        iItemToQuotationService.deleteById(theId);
    }
}
