package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Quotation;

import java.util.List;

public interface IQuotationService {

    List<Quotation> findAll();
    void save(Quotation theQuotation);
    void deleteById(long theId);
}
