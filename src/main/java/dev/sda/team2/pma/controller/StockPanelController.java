package dev.sda.team2.pma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stockpanel")
public class StockPanelController {

    @RequestMapping()
    public String displayPanel() {
        return "stock/stockpanel";
    }

}
