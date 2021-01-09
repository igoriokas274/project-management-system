package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
