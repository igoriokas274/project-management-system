package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
