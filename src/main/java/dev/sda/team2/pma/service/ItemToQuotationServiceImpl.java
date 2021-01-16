package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.ItemToQuotationRepository;
import dev.sda.team2.pma.entity.ItemToQuotation;
import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemToQuotationServiceImpl implements IItemToQuotationService{

    private ItemToQuotationRepository itemToQuotationRepository;

    @Autowired
    public ItemToQuotationServiceImpl(ItemToQuotationRepository theItemToQuotationRepository) {
        itemToQuotationRepository = theItemToQuotationRepository;
    }

    @Override
    public List<ItemToQuotation> findAll() {
        return itemToQuotationRepository.findAll();
    }

    @Override
    @Audit(action = "Item to Quotation saved")
    public void save(ItemToQuotation theItemToQuotation) {
        itemToQuotationRepository.save(theItemToQuotation);
    }

    @Override
    @Audit(action = "Item to Quotation deleted")
    public void deleteById(long theId) {
        itemToQuotationRepository.deleteById(theId);
    }
}
