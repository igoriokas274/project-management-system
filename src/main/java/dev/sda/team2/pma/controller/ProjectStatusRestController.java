package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.ProjectStatusRepository;
import dev.sda.team2.pma.entity.ProjectStatus;
import dev.sda.team2.pma.service.IProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projectstatuses")
public class ProjectStatusRestController {

    private IProjectStatusService projectStatusService;

    @Autowired
    private ProjectStatusRepository projectStatusRepository;

    public ProjectStatusRestController(IProjectStatusService theProjectStatusService) {
        projectStatusService = theProjectStatusService;
    }

    @GetMapping("/list")
    public List<ProjectStatus> listProjectStatuses() {

        return projectStatusService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProjectStatus> showProjectStatusId(@PathVariable("id") long theId) {

        return projectStatusRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteProjectStatusById(@PathVariable("id") long theId) {

        projectStatusService.deleteById(theId);
    }

}
