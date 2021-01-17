package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.ContactRepository;
import dev.sda.team2.pma.entity.Contact;
import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    @Audit (action = "Contact saved")
    public void save(Contact theContact) { contactRepository.save(theContact);
    }

    @Override
    @Transactional
    @Audit(action = "Contact deleted")
    public void deleteById(long theId) { contactRepository.deleteById(theId);
    }
}
