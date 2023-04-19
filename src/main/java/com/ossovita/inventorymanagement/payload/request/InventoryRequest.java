package com.ossovita.inventorymanagement.payload.request;

import lombok.Data;

@Data
public class InventoryRequest {

    private long warehouseId;
    private String inventoryName;
}
