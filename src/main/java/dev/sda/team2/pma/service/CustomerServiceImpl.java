package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.CustomerRepository;
import dev.sda.team2.pma.entity.Customer;
import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
        customerRepository = theCustomerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    @Audit(action = "Customer saved")
    public void save(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    @Transactional
    @Audit(action = "Customer deleted")
    public void deleteById(long theId) {
        customerRepository.deleteById(theId);
    }
}
