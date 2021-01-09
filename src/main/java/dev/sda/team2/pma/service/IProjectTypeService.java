package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.ProjectType;

import java.util.List;

public interface IProjectTypeService {

    List<ProjectType> findAll();
    ProjectType findById(long theId);
    void save (ProjectType theProjectType);
    void deleteById(long theId);
}
