package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {
}
