package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatus, Long> {
}
