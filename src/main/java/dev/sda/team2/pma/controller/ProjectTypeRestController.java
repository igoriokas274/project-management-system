package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.ProjectTypeRepository;
import dev.sda.team2.pma.entity.ProjectType;
import dev.sda.team2.pma.service.IProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projecttypes")
public class ProjectTypeRestController {

    private IProjectTypeService projectTypeService;

    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    public ProjectTypeRestController(IProjectTypeService theProjectTypeService) {
        projectTypeService = theProjectTypeService;
    }

    @GetMapping("/list")
    public List<ProjectType> listProjectTypes() {

        return projectTypeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProjectType> showProjectTypeId(@PathVariable("id") long theId) {

        return projectTypeRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteProjectTypeById(@PathVariable("id") long theId) {

        projectTypeService.deleteById(theId);
    }

}
