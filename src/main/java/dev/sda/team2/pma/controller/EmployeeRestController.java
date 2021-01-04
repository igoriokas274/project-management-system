package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.EmployeeRepository;
import dev.sda.team2.pma.entity.Employee;
import dev.sda.team2.pma.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    private IEmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeRestController(IEmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public List<Employee> listEmployee() {

        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> showEmployeeById(@PathVariable("id") long theId) {

        return employeeRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteEmployeeById(@PathVariable("id") long theId) {

        employeeService.deleteById(theId);
    }


}
