package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Item;

import java.util.List;

public interface IItemService {

    List<Item> findAll();
    void save(Item theItem);
    void deleteById(long theId);
}
