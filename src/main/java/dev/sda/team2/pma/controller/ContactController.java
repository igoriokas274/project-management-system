package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.ContactRepository;
import dev.sda.team2.pma.entity.Contact;
import dev.sda.team2.pma.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projectpanel/contacts")
public class ContactController {

    private IContactService contactService;

    @Autowired
    private ContactRepository contactRepository;

    public ContactController(IContactService theContactService) {
        contactService = theContactService;
    }

    @GetMapping("/list")
    public String listContacts(Model theModel) {

        // List contacts
        List<Contact> theContacts = contactService.findAll();
        theModel.addAttribute("contacts", theContacts);

        // add new contact
        Contact theContact = new Contact();
        theModel.addAttribute("contact", theContact);

        return "projects/list-contacts";
    }

    @PostMapping("/save")
    public String saveContact(Contact contact) {

        contactService.save(contact);
        return "redirect:/projectpanel/contacts/list";
    }

    @GetMapping("/update")
    @ResponseBody
    public Optional<Contact> editContact(@RequestParam("id") long theId) {

        return contactRepository.findById(theId);
    }

    @GetMapping("/delete")
    public String deleteContact(@RequestParam("id") long theId) {

        contactService.deleteById(theId);
        return "redirect:/projectpanel/contacts/list";
    }

}
