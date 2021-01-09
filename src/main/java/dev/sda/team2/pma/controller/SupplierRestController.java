package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.SupplierRepository;
import dev.sda.team2.pma.entity.Supplier;
import dev.sda.team2.pma.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierRestController {

    private ISupplierService supplierService;

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierRestController(ISupplierService theSupplierService) {
        supplierService = theSupplierService;
    }

    @GetMapping("/list")
    public List<Supplier> listSuppliers() {

        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Supplier> showSupplierById(@PathVariable("id") long theId) {

        return supplierRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteSupplierById(@PathVariable("id") long theId) {

        supplierService.deleteById(theId);
    }
}
