package com.ossovita.inventorymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @SequenceGenerator(name = "product_seq", allocationSize = 1)
    @GeneratedValue(generator = "product_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_count")
    private int productCount;

    @Column(name = "product_alert_count")
    private int productAlertCount;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductCategory> productCategoryList;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductInventory> productInventoryList;






}
