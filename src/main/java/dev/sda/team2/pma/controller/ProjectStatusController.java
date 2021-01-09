package dev.sda.team2.pma.controller;


import dev.sda.team2.pma.dao.ProjectStatusRepository;
import dev.sda.team2.pma.entity.ProjectStatus;
import dev.sda.team2.pma.service.IProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/settings/projectstatuses")
public class ProjectStatusController {

    private IProjectStatusService projectStatusService;

    @Autowired
    private ProjectStatusRepository projectStatusRepository;

    public ProjectStatusController(IProjectStatusService theProjectStatusService){projectStatusService = theProjectStatusService;}

    @GetMapping("/list")
    public String listProjectStatuses(Model theModel) {

        List<ProjectStatus> theProjectStatuses = projectStatusService.findAll();
        theModel.addAttribute("project statuses", theProjectStatuses);

        Object projectStatus = new ProjectStatus();
        theModel.addAttribute("project status", theProjectStatuses);

        return "settings/list-projectstatuses";
    }

    @PostMapping("/save")
    public String saveProjectStatus(ProjectStatus theProjectStatus) {

        projectStatusService.save(theProjectStatus);
        return "redirect:/settings/projectstatuses/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<ProjectStatus> editProjectStatus(@RequestParam("id") long theId) {

        return projectStatusRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteProjectStatus(@RequestParam("id") long theId) {

        projectStatusService.deleteById(theId);
        return "redirect:/settings/projectstatuses/list";
    }
}
