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
@Table(name = "inventories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory {

    @Id
    @SequenceGenerator(name = "inventory_seq", allocationSize = 1)
    @GeneratedValue(generator = "inventory_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "inventory_id")
    private long inventoryId;

    @Column(name = "inventory_name")
    private String inventoryName;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false)
    @JsonIgnore
    private Warehouse warehouse;

    @Column(name = "warehouse_id")
    private long warehouseId;


    @OneToMany(mappedBy = "inventory")
    @JsonIgnore
    private List<ProductInventory> productInventoryList;


}
