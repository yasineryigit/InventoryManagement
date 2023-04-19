package com.ossovita.inventorymanagement.payload.request;

import lombok.Data;

@Data
public class WarehouseRequest {

    private String warehouseName;

    private String addressCountry;

    private String addressRegion;

    private String addressCity;

    private String addressTown;

    private String addressDetailed;


}
