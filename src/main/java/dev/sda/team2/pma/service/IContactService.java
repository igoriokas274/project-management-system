package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Contact;

import java.util.List;

public interface IContactService {

    List<Contact> findAll();
    void save(Contact theContact);
    void deleteById(long theId);

}
