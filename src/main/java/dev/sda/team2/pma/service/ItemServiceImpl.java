package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.ItemRepository;
import dev.sda.team2.pma.entity.Item;
import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService{

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository theIemRepository) {
        itemRepository = theIemRepository;
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    @Audit(action = "Item saved")
    public void save(Item theItem) {
        itemRepository.save(theItem);
    }

    @Override
    @Audit(action = "Item deleted")
    public void deleteById(long theId) {
        itemRepository.deleteById(theId);
    }
}
