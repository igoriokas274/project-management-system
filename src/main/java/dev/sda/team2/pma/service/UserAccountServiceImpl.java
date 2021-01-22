package dev.sda.team2.pma.service;

import dev.sda.team2.pma.dao.UserAccountRepository;
import dev.sda.team2.pma.entity.UserAccount;
import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserAccountServiceImpl implements IUserAccountService {

    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository theUserAccountRepository) {
        userAccountRepository = theUserAccountRepository;
    }

    @Override
    public List<UserAccount> findAll () { return userAccountRepository.findAll();
    }

    @Override
    @Transactional
    @Audit(action ="User Account saved" )
    public void save ( UserAccount theUserAccount) { userAccountRepository.save(theUserAccount);
    }

    @Override
    @Transactional
    @Audit (action = "User Account deleted")
    public void deleteById(long theId) {
        userAccountRepository.deleteById(theId);
    }
}
