package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    public List<Employee> findAll();
    /*public Employee findById(long theId);*/
    public void save(Employee theEmployee);
    public void deleteById(long theId);
}
