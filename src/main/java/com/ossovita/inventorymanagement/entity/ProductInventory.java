package com.ossovita.inventorymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_inventories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductInventory {

    @Id
    @SequenceGenerator(name = "product_inventories_seq", allocationSize = 1)
    @GeneratedValue(generator = "product_inventories_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "product_inventory_id")
    private long productInventoryId;


    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @JsonIgnore
    private Product product;

    @Column(name = "product_id")
    private long productId;


    @ManyToOne
    @JoinColumn(name = "inventory_id", insertable = false, updatable = false)
    @JsonIgnore
    private Inventory inventory;

    @Column(name = "inventory_id")
    private long inventoryId;

}
