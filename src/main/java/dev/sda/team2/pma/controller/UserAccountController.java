package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.UserAccountRepository;
import dev.sda.team2.pma.entity.UserAccount;
import dev.sda.team2.pma.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/adminpanel/users")
public class UserAccountController {

    private IUserAccountService userAccountService;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    public UserAccountController(IUserAccountService theUserAccountService) {
        userAccountService = theUserAccountService;
    }

    @GetMapping( "/list")
    public String listUserAccounts(Model theModel) {

        // list users
        List<UserAccount> theUserAccounts = userAccountService.findAll();
        theModel.addAttribute("usersAccounts", theUserAccounts);

        // add new user
        UserAccount userAccount = new UserAccount();
        theModel.addAttribute("userAccount", userAccount);

        return "adminpanel/list-users";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<UserAccount> updateUser(@RequestParam("id") long theId) {

        return userAccountRepository.findById(theId);
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
