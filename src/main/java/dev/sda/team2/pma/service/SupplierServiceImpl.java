package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.SupplierRepository;
import dev.sda.team2.pma.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository theSupplierRepository) {
        supplierRepository = theSupplierRepository;
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public void save(Supplier theSupplier) {
        supplierRepository.save(theSupplier);
    }

    @Override
    public void deleteById(long theId) {
        supplierRepository.deleteById(theId);
    }
}
