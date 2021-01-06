package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
    void save(Customer theCustomer);
    void deleteById(long theId);
}
