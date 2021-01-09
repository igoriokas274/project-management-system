package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.StockType;

import java.util.List;

public interface IStockTypeService {

    List<StockType> findAll();
    StockType findById(long theId);
    void save (StockType theStockType);
    void deleteById(long theId);
}
