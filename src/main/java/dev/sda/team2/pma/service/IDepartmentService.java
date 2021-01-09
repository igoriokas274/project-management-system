package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();
    Department findById(long theId);
    void save(Department theDepartment);
    void deleteById(long theId);
}
