package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.StockTypeRepository;
import dev.sda.team2.pma.entity.StockType;
import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockTypeImpl implements IStockTypeService {

    private StockTypeRepository stockTypeRepository;

    @Autowired
    public void StockTypeRepository(StockTypeRepository theStockTypeRepository) {
        stockTypeRepository = theStockTypeRepository;
    }

    @Override
    public List<StockType> findAll() {
        return stockTypeRepository.findAll();
    }

    @Override
    public StockType findById(long theId) {

        Optional<StockType> result = stockTypeRepository.findById(theId);
        StockType theStockType;
        if (result.isPresent()) {
            theStockType = result.get();
        } else {
            throw new RuntimeException("Did not find Stock type id" + theId);
        }
        return theStockType;
    }

    @Override
    @Audit(action = "Stock type saved")
    public void save(StockType theStockType) {
        stockTypeRepository.save(theStockType);
    }

    @Override
    @Audit(action = "Stock type deleted")
    public void deleteById(long theId) {
        stockTypeRepository.deleteById(theId);
    }
}
