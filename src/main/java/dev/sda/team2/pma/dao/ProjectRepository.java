package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
