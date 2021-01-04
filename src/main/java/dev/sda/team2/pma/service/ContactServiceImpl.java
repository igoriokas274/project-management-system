package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.ContactRepository;
import dev.sda.team2.pma.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements IContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository theContactRepository) {
        contactRepository = theContactRepository;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(long theId) {

        Optional<Contact> result = contactRepository.findById(theId);
        Contact theContact = null;
        if(result.isPresent()) {
            theContact = result.get();
        } else {
            throw new RuntimeException("Did not find Contact id " + theId);
        }

        return theContact;
    }

    @Override
    public void save(Contact theContact) {

        contactRepository.save(theContact);

    }

    @Override
    public void deleteById(long theId) {

        contactRepository.deleteById(theId);

    }
}
