package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();
    void save(Employee theEmployee);
    void deleteById(long theId);
}
