package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    private ISupplierService iSupplierService;

    @Autowired
    public SupplierServiceImpl(ISupplierService theISupplierService) {
        iSupplierService = theISupplierService;
    }

    @Override
    public List<Supplier> findAll() {
        return iSupplierService.findAll();
    }

    @Override
    public void save(Supplier theSupplier) {
        iSupplierService.save(theSupplier);
    }

    @Override
    public void deleteById(long theId) {
        iSupplierService.deleteById(theId);
    }
}
