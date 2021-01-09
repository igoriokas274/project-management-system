package dev.sda.team2.pma.controller;


import dev.sda.team2.pma.dao.DepartmentRepository;
import dev.sda.team2.pma.entity.Department;
import dev.sda.team2.pma.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/settings/departments")
public class DepartmentController {

    private IDepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentController(IDepartmentService theDepartmentService){departmentService = theDepartmentService;}

    @GetMapping("/list")
    public String listDepartments(Model theModel) {

        List<Department> theDepartments = departmentService.findAll();
        theModel.addAttribute("departments", theDepartments);

        Object department = new Department();
        theModel.addAttribute("departments", theDepartments);

        return "settings/list-departments";
    }

    @PostMapping("/save")
    public String saveDepartment (Department theDepartment) {

        departmentService.save(theDepartment);
        return "redirect:/settings/departments/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<Department> editDepartment(@RequestParam("id") long theId) {

        return departmentRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteDepartment(@RequestParam("id") long theId) {

        departmentService.deleteById(theId);
        return "redirect:/settings/departments/list";
    }
}
