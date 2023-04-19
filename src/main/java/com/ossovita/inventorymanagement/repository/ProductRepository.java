package com.ossovita.inventorymanagement.repository;

import com.ossovita.inventorymanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p " +
            "join p.productInventoryList pi " +
            "join pi.inventory inv " +
            "join inv.warehouse w " +
            "where w.warehouseId = :warehouseId and p.productName=:productName")
    List<Product> getProductsByProductNameAndWarehouseId(@Param("productName") String productName, @Param("warehouseId") long warehouseId);

    @Query("select p from Product  p " +
            "join  p.productInventoryList pi " +
            "join pi.inventory inv " +
            "join inv.warehouse w " +
            "join w.address a " +
            "where a.addressRegion =:addressRegion and p.productName=:productName")
    List<Product> getProductsByProductNameAndWarehouseAddressRegion(@Param("productName") String productName, @Param("addressRegion") String addressRegion);


    @Query("select p from Product  p " +
            "join  p.productInventoryList pi " +
            "join pi.inventory inv " +
            "join inv.warehouse w " +
            "join w.address a " +
            "where a.addressCity =:addressCity and p.productName=:productName")
    List<Product> getProductsByProductNameAndWarehouseAddressCity(@Param("productName") String productName, @Param("addressCity") String addressCity);

    @Query("select p from Product p " +
            "join p.productCategoryList pc " +
            "where pc.categoryId=:categoryId and p.productName=:productName")
    List<Product> getProductsByProductNameAndCategoryId(@Param("productName") String productName, @Param("categoryId") long categoryId);
}
