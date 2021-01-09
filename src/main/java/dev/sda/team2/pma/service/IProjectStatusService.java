package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.ProjectStatus;

import java.util.List;

public interface IProjectStatusService {

        List<ProjectStatus> findAll();
        ProjectStatus findById(long theId);
        void save(ProjectStatus theProjectStatus);
        void deleteById(long theId);
    }
