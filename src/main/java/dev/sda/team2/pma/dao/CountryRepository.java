package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
