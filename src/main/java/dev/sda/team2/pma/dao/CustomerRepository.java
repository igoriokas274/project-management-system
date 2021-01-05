package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
