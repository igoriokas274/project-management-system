package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.entity.Employee;
import dev.sda.team2.pma.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    private IEmployeeService employeeService;

    public EmployeeRestController(IEmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public List<Employee> listEmployee() {

        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee showEmployeeById(@PathVariable("id") long theId) {

        return employeeService.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteEmployeeById(@PathVariable("id") long theId) {

        employeeService.deleteById(theId);
    }


}
