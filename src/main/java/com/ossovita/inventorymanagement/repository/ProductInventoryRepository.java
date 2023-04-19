package com.ossovita.inventorymanagement.repository;

import com.ossovita.inventorymanagement.entity.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long> {

    void deleteByProductId(long productId);

    Optional<ProductInventory> findProductInventoryByInventoryId(long inventory);

}
