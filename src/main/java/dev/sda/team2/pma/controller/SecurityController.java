package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.UserAccountRepository;
import dev.sda.team2.pma.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminpanel/register")
public class SecurityController {

    @Autowired
    UserAccountRepository accountRepo;

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    @GetMapping("/new")
    public String register(Model model) {
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount", userAccount);
        return "security/register";
    }

    @PostMapping("/save")
    public String saveUser(Model model, UserAccount user) {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        accountRepo.save(user);
        return "redirect:/adminpanel";
    }

}