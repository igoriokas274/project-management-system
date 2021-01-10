package dev.sda.team2.pma.controller;


import dev.sda.team2.pma.dao.ProjectTypeRepository;
import dev.sda.team2.pma.entity.ProjectType;
import dev.sda.team2.pma.service.IProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/settings/projecttypes")
public class ProjectTypeController {

    private final IProjectTypeService projectTypeService;
    private IProjectTypeService theProjectTypeService;

    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    public ProjectTypeController(IProjectTypeService theProjectTypeService){projectTypeService = theProjectTypeService;}

    @GetMapping("/list")
    public String listProjectTypes(Model theModel) {

        List<ProjectType> theProjectTypes = projectTypeService.findAll();
        theModel.addAttribute("projectTypes", theProjectTypes);

        Object theProjectType = new ProjectType();
        theModel.addAttribute("projectType", theProjectType);

        return "settings/list-projecttypes";
    }

    @PostMapping("/save")
    public String saveProjectType(ProjectType theProjectType) {

        projectTypeService.save(theProjectType);
        return "redirect:/settings/projecttypes/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<ProjectType> editProjectType(@RequestParam("id") long theId) {

        return projectTypeRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteProjectType(@RequestParam("id") long theId) {

        projectTypeService.deleteById(theId);
        return "redirect:/settings/projecttypes/list";
    }
}
