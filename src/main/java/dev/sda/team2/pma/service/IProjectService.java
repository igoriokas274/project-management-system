package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Project;

import java.util.List;

public interface IProjectService {

    List<Project> findAll();
    void save(Project theProject);
    void deleteById(long theId);
}
