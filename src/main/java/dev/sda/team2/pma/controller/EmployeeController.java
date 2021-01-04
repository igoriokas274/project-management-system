package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.entity.Employee;
import dev.sda.team2.pma.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/team/employee")
public class EmployeeController {

    private IEmployeeService employeeService;

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
    public String editEmployee(@RequestParam("id") long theId, Model theModel) {

        Employee theEmployee = employeeService.findById(theId);
        theModel.addAttribute("employee", theEmployee);
        return "team/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") long theId) {

        employeeService.deleteById(theId);
        return "redirect:/team/employee/list";
    }

}
