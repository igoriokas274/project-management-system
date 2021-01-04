package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
