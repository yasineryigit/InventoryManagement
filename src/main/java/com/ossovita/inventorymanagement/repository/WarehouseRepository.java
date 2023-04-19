package com.ossovita.inventorymanagement.repository;

import com.ossovita.inventorymanagement.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query("SELECT DISTINCT w FROM Warehouse w " +
            "JOIN w.inventoryList inv " +
            "JOIN inv.productInventoryList pi " +
            "JOIN pi.product p " +
            "WHERE p.productName = :productName")
    List<Warehouse> findWarehousesByProductName(@Param("productName") String productName);


}
