package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
