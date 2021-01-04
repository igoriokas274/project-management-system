package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.EmployeeRepository;
import dev.sda.team2.pma.entity.Employee;
import dev.sda.team2.pma.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/team/employee")
public class EmployeeController {

    private IEmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listUserEmployees(Model theModel) {

        // list employee
        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees", theEmployees);

        // add new employee
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);

        return "team/list-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee theEmployee) {

        employeeService.save(theEmployee);
        return "redirect:/team/employee/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<Employee> editEmployee(@RequestParam("id") long theId) {

        return employeeRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") long theId) {

        employeeService.deleteById(theId);
        return "redirect:/team/employee/list";
    }

}
