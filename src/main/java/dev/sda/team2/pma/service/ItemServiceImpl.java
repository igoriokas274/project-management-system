package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService{

    private IItemService iItemService;

    @Autowired
    public ItemServiceImpl(IItemService theItemService) {
        iItemService = theItemService;
    }

    @Override
    public List<Item> findAll() {
        return iItemService.findAll();
    }

    @Override
    public void save(Item theItem) {
        iItemService.save(theItem);
    }

    @Override
    public void deleteById(long theId) {
        iItemService.deleteById(theId);
    }
}
