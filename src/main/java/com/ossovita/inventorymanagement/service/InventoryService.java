package com.ossovita.inventorymanagement.service;

import com.ossovita.inventorymanagement.entity.Inventory;
import com.ossovita.inventorymanagement.payload.request.InventoryRequest;

import java.util.List;

public interface InventoryService {
    Inventory createInventory(InventoryRequest inventoryRequest);

    List<Inventory> getAllInventories();
}
