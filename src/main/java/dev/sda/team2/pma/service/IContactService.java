package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Contact;

import java.util.List;

public interface IContactService {

    List<Contact> findAll();
    Contact findById(long theId);
    void save(Contact theContact);
    void deleteById(long theId);

}
