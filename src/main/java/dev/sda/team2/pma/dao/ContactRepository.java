package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
