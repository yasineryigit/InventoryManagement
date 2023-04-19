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
@Table(name = "warehouses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Warehouse {

    @Id
    @SequenceGenerator(name = "warehouse_seq", allocationSize = 1)
    @GeneratedValue(generator = "warehouse_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "warehouse_id")
    private long warehouseId;

    @Column(name = "warehouse_name")
    private String warehouseName;

    @OneToMany(mappedBy = "warehouse")
    @JsonIgnore
    private List<Inventory> inventoryList;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private Address address;

    @Column(name = "address_id")
    private long addressId;


}
