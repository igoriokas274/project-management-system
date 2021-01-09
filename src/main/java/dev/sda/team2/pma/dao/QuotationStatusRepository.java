package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.QuotationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationStatusRepository extends JpaRepository<QuotationStatus, Long> {
}
