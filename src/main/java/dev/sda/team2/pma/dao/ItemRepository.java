package dev.sda.team2.pma.dao;

import dev.sda.team2.pma.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
