package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.ItemRepository;
import dev.sda.team2.pma.entity.Item;
import dev.sda.team2.pma.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stockpanel/items")
public class ItemController {

    private IItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    public ItemController(IItemService theItemService) {
        itemService = theItemService;
    }

    @GetMapping("/list")
    public String listItems(Model theModel) {

        // List items
        List<Item> theItems = itemService.findAll();
        theModel.addAttribute("items", theItems);

        // add new item
        Item theItem = new Item();
        theModel.addAttribute("item", theItem);

        return "stock/list-items";
    }

    @PostMapping("/save")
    public String saveItem(Item theItem) {

        itemService.save(theItem);
        return "redirect:/stockpanel/items/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<Item> editItem(@RequestParam("id") long theId) {

        return itemRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteItem(@RequestParam("id") long theId) {

        itemService.deleteById(theId);
        return "redirect:/stockpanel/items/list";
    }

}
