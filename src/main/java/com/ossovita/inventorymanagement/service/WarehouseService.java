package com.ossovita.inventorymanagement.service;

import com.ossovita.inventorymanagement.payload.request.WarehouseRequest;
import com.ossovita.inventorymanagement.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    Warehouse createWarehouse(WarehouseRequest warehouseRequest);

    List<Warehouse> getAllWarehouses();

    List<Warehouse> getByProductName(String productName);
}
