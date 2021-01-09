package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.StockTypeRepository;
import dev.sda.team2.pma.entity.StockType;
import dev.sda.team2.pma.service.IStockTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocktypes")
public class StockTypeRestController {

    private IStockTypeService stockTypeService;

    @Autowired
    private StockTypeRepository stockTypeRepository;

    public StockTypeRestController(IStockTypeService theStockTypeService) {
        stockTypeService = theStockTypeService;
    }

    @GetMapping("/list")
    public List<StockType> listStockTypes() {

        return stockTypeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<StockType> showStockTypeId(@PathVariable("id") long theId) {

        return stockTypeRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteStockTypeById(@PathVariable("id") long theId) {

        stockTypeService.deleteById(theId);
    }

}
