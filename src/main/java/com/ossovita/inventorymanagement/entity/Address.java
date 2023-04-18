package com.ossovita.inventorymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @SequenceGenerator(name = "address_seq", allocationSize = 1)
    @GeneratedValue(generator = "address_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id")
    private long addressId;


    @Column(name = "address_country")
    private String addressCountry;

    @Column(name = "address_region")
    private String addressRegion;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_town")
    private String addressTown;

    @Column(name = "address_detailed")
    private String addressDetailed;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false)
    private Warehouse warehouse;

    @Column(name = "warehouse_id")
    private long warehouseId;





}
