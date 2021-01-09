package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
