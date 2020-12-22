package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}
