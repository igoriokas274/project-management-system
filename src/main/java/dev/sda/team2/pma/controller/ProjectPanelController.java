package dev.sda.team2.pma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projectpanel")
public class ProjectPanelController {

    @RequestMapping
    public String displayPanel() {
        return "projects/projectpanel";
    }

}
