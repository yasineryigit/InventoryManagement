package com.ossovita.inventorymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCategories {

    @Id
    @SequenceGenerator(name = "product_categories_seq", allocationSize = 1)
    @GeneratedValue(generator = "product_categories_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "product_category_id")
    private long productCategoryId;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @JsonIgnore
    private Product product;

    @Column(name = "product_id")
    private long product_id;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;

    @Column(name = "category_id")
    private long category_id;




}
