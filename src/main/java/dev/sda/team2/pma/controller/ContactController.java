package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.entity.Contact;
import dev.sda.team2.pma.service.IContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private IContactService contactService;

    public ContactController(IContactService theContactService) {
        contactService = theContactService;
    }

    @GetMapping("/list")
    public String listContacts(Model theModel) {

        List<Contact> theContacts = contactService.findAll();
        theModel.addAttribute("contacts", theContacts);

        return "contacts/list-contacts";

    }

    @GetMapping("/addContact")
    public String addNewUser(Model theModel) {

        Contact theContact = new Contact();
        theModel.addAttribute("contact", theContact);
        return "contacts/contact-form";

    }

    @PostMapping("/save")
    public String saveContact(Contact contact) {

        contactService.save(contact);
        return "redirect:/contacts/list";

    }

}
