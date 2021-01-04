package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.UserAccount;

import java.util.List;

public interface IUserAccountService {

    List<UserAccount> findAll();
    void save(UserAccount theUserAccount);
    void deleteById(long theId);

}
