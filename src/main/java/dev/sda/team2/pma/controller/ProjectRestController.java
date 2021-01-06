package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.ProjectRepository;
import dev.sda.team2.pma.entity.Project;
import dev.sda.team2.pma.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

    private IProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectRestController(IProjectService theProjectService) {
        projectService = theProjectService;
    }

    @GetMapping("/list")
    public List<Project> listProjects() {

        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Project> showProjectById(@PathVariable("id") long theId) {

        return projectRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteProjectById(@PathVariable("id") long theId) {

        projectService.deleteById(theId);
    }
}
