package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.CustomerRepository;
import dev.sda.team2.pma.entity.Customer;
import dev.sda.team2.pma.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    private ICustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerRestController(ICustomerService theCustomerService) {
        customerService = theCustomerService;
    }

    @GetMapping("/list")
    public List<Customer> listCustomers() {

        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> showCustomerById(@PathVariable("id") long theId) {

        return customerRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteCustomerById(@PathVariable("id") long theId) {

        customerService.deleteById(theId);
    }
}
