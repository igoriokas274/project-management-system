package dev.sda.team2.pma.service;

import dev.sda.team2.pma.entity.UserAccount;

import java.util.List;

public interface IUserAccountService {

    public List<UserAccount> findAll();
/*    public UserAccount findById(long theId);*/
    public void save(UserAccount theUserAccount);
    public void deleteById(long theId);

}
