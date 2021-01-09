package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.PayTerm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface PayTermRepository extends JpaRepository<PayTerm, Long> {

}
