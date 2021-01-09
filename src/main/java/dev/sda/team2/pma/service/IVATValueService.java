package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.VATValue;

import java.util.List;

public interface IVATValueService {

    List<VATValue> findAll();
    VATValue findById(long theId);
    void save (VATValue theVATValue);
    void deleteById(long theId);
}
