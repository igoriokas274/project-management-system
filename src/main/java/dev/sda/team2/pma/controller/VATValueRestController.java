package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.VATValueRepository;
import dev.sda.team2.pma.entity.VATValue;
import dev.sda.team2.pma.service.IVATValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vatvalues")
public class VATValueRestController {

    private IVATValueService vatValueService;

    @Autowired
    private VATValueRepository vatValueRepository;

    public VATValueRestController(IVATValueService theVATValueService) {
        vatValueService = theVATValueService;
    }

    @GetMapping("/list")
    public List<VATValue> listVATValues() {

        return vatValueService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<VATValue> showVATValueById(@PathVariable("id") long theId) {

        return vatValueRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteVATValueById(@PathVariable("id") long theId) {

        vatValueService.deleteById(theId);
    }
}
