package com.ossovita.inventorymanagement.repository;

import com.ossovita.inventorymanagement.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    void deleteByProductId(long productId);

    Optional<ProductCategory> findProductCategoryByProductId(long productId);
}
