package dev.sda.team2.pma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminpanel")
public class AdminPanelController {

    @RequestMapping()
    public String displayPanel() {
        return "adminpanel/adminpanel";
    }

}
