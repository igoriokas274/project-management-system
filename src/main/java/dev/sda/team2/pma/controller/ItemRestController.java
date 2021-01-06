package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.ItemRepository;
import dev.sda.team2.pma.entity.Item;
import dev.sda.team2.pma.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemRestController {

    private IItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    public ItemRestController(IItemService theItemService) {
        itemService = theItemService;
    }

    @GetMapping("/list")
    public List<Item> listItems() {

        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Item> showItemById(@PathVariable("id") long theId) {

        return itemRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteItemById(@PathVariable("id") long theId) {

        itemService.deleteById(theId);
    }
}
