package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.StockTypeRepository;
import dev.sda.team2.pma.entity.StockType;
import dev.sda.team2.pma.service.IStockTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/settings/stocktypes")
public class StockTypeController {

    private IStockTypeService stockTypeService;

    @Autowired
    private StockTypeRepository stockTypeRepository;

    public StockTypeController(IStockTypeService theStockTypeService) {
        stockTypeService = theStockTypeService;
    }

    @GetMapping("/list")
    public String listStockTypes(Model theModel) {

        List<StockType> theStockTypes = stockTypeService.findAll();
        theModel.addAttribute("stockTypes", theStockTypes);

        StockType theStockType = new StockType();
        theModel.addAttribute("stockType", theStockType);

        return "settings/list-stocktypes";
    }

    @PostMapping("/save")
    public String saveStockType(StockType theStockType) {

        stockTypeService.save(theStockType);
        return "redirect:/settings/stocktypes/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<StockType> editStockType(@RequestParam("id") long theId) {

        return stockTypeRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteStocktype(@RequestParam("id") long theId) {

        stockTypeService.deleteById(theId);
        return "redirect:/settings/stocktypes/list";
    }

}
