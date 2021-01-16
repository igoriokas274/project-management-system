package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.EmployeeRepository;
import dev.sda.team2.pma.entity.Employee;
import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Audit(action = "Employee saved")
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    @Audit(action = "Employee deleted")
    public void deleteById(long theId) {
        employeeRepository.deleteById(theId);
    }

}
