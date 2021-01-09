package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.SupplierRepository;
import dev.sda.team2.pma.entity.Supplier;
import dev.sda.team2.pma.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stockpanel/suppliers")
public class SupplierController {

    private ISupplierService supplierService;

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierController(ISupplierService theSupplierService) {
        supplierService = theSupplierService;
    }

    @GetMapping("/list")
    public String listSuppliers(Model theModel) {

        // List suppliers
        List<Supplier> theSuppliers = supplierService.findAll();
        theModel.addAttribute("suppliers", theSuppliers);

        // add new supplier
        Supplier theSupplier = new Supplier();
        theModel.addAttribute("supplier", theSupplier);

        return "stock/list-suppliers";
    }

    @PostMapping("/save")
    public String saveSupplier(Supplier theSupplier) {

        supplierService.save(theSupplier);
        return "redirect:/stockpanel/suppliers/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<Supplier> editSupplier(@RequestParam("id") long theId) {

        return supplierRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteSupplier(@RequestParam("id") long theId) {

        supplierService.deleteById(theId);
        return "redirect:/stockpanel/suppliers/list";
    }

}
