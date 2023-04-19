package com.ossovita.inventorymanagement.controller;

import com.ossovita.inventorymanagement.entity.Inventory;
import com.ossovita.inventorymanagement.payload.request.InventoryRequest;
import com.ossovita.inventorymanagement.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/create")
    public Inventory createInventory(@RequestBody InventoryRequest inventoryRequest){
        return inventoryService.createInventory(inventoryRequest);
    }

    @GetMapping("/get-all")
    public List<Inventory> getAllInventories(){
        return inventoryService.getAllInventories();
    }
}
