package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Supplier;

import java.util.List;

public interface ISupplierService {

    List<Supplier> findAll();
    void save(Supplier theSupplier);
    void deleteById(long theId);
}
