package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.VATValueRepository;
import dev.sda.team2.pma.entity.VATValue;
import dev.sda.team2.pma.service.IVATValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/settings/vatvalues")
public class VATValueController {

    private IVATValueService vatValueService;

    @Autowired
    private VATValueRepository vatValueRepository;

    public VATValueController(IVATValueService theVATValueService) {
        vatValueService = theVATValueService;
    }

    @GetMapping("/list")
    public String listVATValues (Model theModel) {

        List<VATValue> theVATValues = vatValueService.findAll();
        theModel.addAttribute("VAT values", theVATValues);

        VATValue theVATValue = new VATValue();
        theModel.addAttribute("VAT value", theVATValue);

        return "settings/list-vatvalues";
    }

    @PostMapping("/save")
    public String saveVATValues(VATValue theVATValue) {

        vatValueService.save(theVATValue);
        return "redirect:/settings/vatvalues/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<VATValue> editVATValues(@RequestParam("id") long theId) {

        return vatValueRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteVATValue(@RequestParam("id") long theId) {

        vatValueService.deleteById(theId);
        return "redirect:/settings/vatvalues/list";
    }

}
