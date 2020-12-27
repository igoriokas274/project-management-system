package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.Contact;

import java.util.List;

public interface IContactService {

    public List<Contact> findAll();
    public Contact findById(long theId);
    public void save(Contact theContact);
    public void deleteById(long theId);

}
