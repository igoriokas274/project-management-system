package dev.sda.team2.pma.controller;

import dev.sda.team2.pma.dao.ContactRepository;
import dev.sda.team2.pma.entity.Contact;
import dev.sda.team2.pma.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
public class ContactRestController {

    private IContactService contactService;

    @Autowired
    private ContactRepository contactRepository;

    public ContactRestController(IContactService theContactService) {
        contactService = theContactService;
    }

    @GetMapping("/list")
    public List<Contact> listContacts() {

        return contactService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Contact> showContactById(@PathVariable("id") long theId) {

        return contactRepository.findById(theId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteContactById(@PathVariable("id") long theId) {

        contactService.deleteById(theId);
    }
}
