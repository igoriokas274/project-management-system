package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.ProjectRepository;
import dev.sda.team2.pma.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements IProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository theProjectRepository) {
        projectRepository = theProjectRepository;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void save(Project theProject) {
        projectRepository.save(theProject);
    }

    @Override
    public void deleteById(long theId) {
        projectRepository.deleteById(theId);
    }
}