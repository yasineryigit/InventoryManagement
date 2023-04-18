package com.ossovita.inventorymanagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "warehouse")
    @JsonIgnore
    private Address address;



}
