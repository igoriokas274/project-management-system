package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.entity.UserAccount;
import dev.sda.team2.pma.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/adminpanel/users")
public class UserAccountController {

    private IUserAccountService userAccountService;

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    public UserAccountController(IUserAccountService theUserAccountService) {
        userAccountService = theUserAccountService;
    }

    @GetMapping( "/list")
    public String listUserAccounts(Model theModel) {

        List<UserAccount> theUserAccounts = userAccountService.findAll();
        theModel.addAttribute("usersAccounts", theUserAccounts);

        return "adminpanel/list-users";
    }

    @GetMapping("/addUser")
    public String addNewUser(Model theModel) {

        UserAccount userAccount = new UserAccount();
        theModel.addAttribute("userAccount", userAccount);

        return "adminpanel/user-form";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") long theId, Model theModel) {

        UserAccount theUserAccount = userAccountService.findById(theId);
        theModel.addAttribute("userAccount", theUserAccount);

        return "adminpanel/user-form";
    }

    @PostMapping("/save")
    public String saveUser(UserAccount user) {

        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        userAccountService.save(user);
        return "redirect:/adminpanel/users/list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") long theId) {

        userAccountService.deleteById(theId);
        return "redirect:/adminpanel/users/list";
    }
}
