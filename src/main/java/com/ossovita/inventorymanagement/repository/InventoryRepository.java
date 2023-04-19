package com.ossovita.inventorymanagement.repository;

import com.ossovita.inventorymanagement.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {


}
