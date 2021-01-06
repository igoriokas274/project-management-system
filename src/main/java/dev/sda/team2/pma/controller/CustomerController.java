package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.CustomerRepository;
import dev.sda.team2.pma.entity.Customer;
import dev.sda.team2.pma.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projectpanel/customers")
public class CustomerController {

    private ICustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController(ICustomerService theCustomerService) {
        customerService = theCustomerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        // List customers
        List<Customer> theCustomers = customerService.findAll();
        theModel.addAttribute("customers", theCustomers);

        // add new customers
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);

        return "projects/list-customers";
    }

    @PostMapping("/save")
    public String saveCustomer(Customer theCustomer) {

        customerService.save(theCustomer);
        return "redirect:/projectpanel/customers/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<Customer> editCustomer(@RequestParam("id") long theId) {

        return customerRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") long theId) {

        customerService.deleteById(theId);
        return "redirect:/projectpanel/customers/list";
    }

}
