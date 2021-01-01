package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.UserAccountRepository;
import dev.sda.team2.pma.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements IUserAccountService {

    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository theUserAccountRepository) {
        userAccountRepository = theUserAccountRepository;
    }

    @Override
    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();
    }

/*    @Override
    public UserAccount findById(long theId) {
        Optional<UserAccount> result = userAccountRepository.findById(theId);
        UserAccount theUserAccount = null;
        if(result.isPresent()) {
            theUserAccount = result.get();
        } else {
            throw new RuntimeException("Did not find User Account id " + theId);
        }

        return theUserAccount;
    }*/

    @Override
    public void save(UserAccount theUserAccount) {
        userAccountRepository.save(theUserAccount);
    }

    @Override
    public void deleteById(long theId) {
        userAccountRepository.deleteById(theId);
    }
}