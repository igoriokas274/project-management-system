package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.ProjectType;
import dev.sda.team2.pma.entity.QuotationStatus;

import java.util.List;

public interface IQuotationStatusService {

    List<QuotationStatus> findAll();
    QuotationStatus findById(long theId);
    void save (QuotationStatus theQuotationStatus);
    void deleteById(long theId);
}
