package com.ossovita.inventorymanagement.controller;

import com.ossovita.inventorymanagement.payload.request.WarehouseRequest;
import com.ossovita.inventorymanagement.entity.Warehouse;
import com.ossovita.inventorymanagement.service.WarehouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello world";
    }

    @PostMapping("/create")
    public Warehouse createWarehouse(@RequestBody WarehouseRequest warehouseRequest){
        return warehouseService.createWarehouse(warehouseRequest);
    }

    @GetMapping("/get-all")
    public List<Warehouse> getAllWarehouses(){
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("get-by-product-name")
    public List<Warehouse> getByProductName(@RequestParam String productName){return warehouseService.getByProductName(productName); }

}
