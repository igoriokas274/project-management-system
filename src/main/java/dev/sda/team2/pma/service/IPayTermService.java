package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.PayTerm;

import java.math.BigDecimal;
import java.util.List;

public interface IPayTermService {

    List<PayTerm> findAll();
    void save(PayTerm thePayTerm);
    void deleteById(Long theId);
}
