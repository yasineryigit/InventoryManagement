package com.ossovita.inventorymanagement.repository;

import com.ossovita.inventorymanagement.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
