package dev.sda.team2.pma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DashboardController {

    @RequestMapping()
    public String displayDashboard() {
        return "main/dashboard";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "errors/access-denied";
    }
}
