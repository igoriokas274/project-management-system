package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.DepartmentRepository;
import dev.sda.team2.pma.entity.Department;
import dev.sda.team2.pma.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentRestController {

    private IDepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentRestController(IDepartmentService theDepartmentService) {
        departmentService = theDepartmentService;
    }

    @GetMapping("/list")
    public List<Department> listDepartments() {

        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> showDepartmentId(@PathVariable("id") long theId) {

        return departmentRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteDepartmentById(@PathVariable("id") long theId) {

        departmentService.deleteById(theId);
    }

}
