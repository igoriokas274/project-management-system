package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.ItemToQuotation;

import java.util.List;

public interface IItemToQuotationService {

    List<ItemToQuotation> findAll();
    void save(ItemToQuotation theItemToQuotation);
    void deleteById(long theId);
}
