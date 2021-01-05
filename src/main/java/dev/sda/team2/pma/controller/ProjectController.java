package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.ProjectRepository;
import dev.sda.team2.pma.entity.Project;
import dev.sda.team2.pma.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projectpanel/projects")
public class ProjectController {

    private IProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectController(IProjectService theProjectService) {
        projectService = theProjectService;
    }

    @GetMapping("/list")
    public String listProjects(Model theModel) {

        // List projects
        List<Project> theProjects = projectService.findAll();
        theModel.addAttribute("projects", theProjects);

        // add new project
        Project theProject = new Project();
        theModel.addAttribute("project", theProject);

        return "projects/list-projects";
    }

    @PostMapping("/save")
    public String saveProject(Project theProject) {

        projectService.save(theProject);
        return "redirect:/projectpanel/projects/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<Project> editProject(@RequestParam("id") long theId) {

        return projectRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteProject(@RequestParam("id") long theId) {

        projectService.deleteById(theId);
        return "redirect:/projectpanel/projects/list";
    }
}
