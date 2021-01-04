package dev.sda.team2.pma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class SettingsPanelController {

    @RequestMapping
    public String displayPanel() {
        return "settings/settingspanel";
    }

}
