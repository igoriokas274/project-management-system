package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.StockType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTypeRepository extends JpaRepository<StockType, Long> {
}
