package com.ossovita.inventorymanagement.service.impl;

import com.ossovita.inventorymanagement.entity.Inventory;
import com.ossovita.inventorymanagement.payload.request.InventoryRequest;
import com.ossovita.inventorymanagement.repository.InventoryRepository;
import com.ossovita.inventorymanagement.service.InventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    ModelMapper modelMapper;
    InventoryRepository inventoryRepository;

    public InventoryServiceImpl(ModelMapper modelMapper, InventoryRepository inventoryRepository) {
        this.modelMapper = modelMapper;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory createInventory(InventoryRequest inventoryRequest) {
        Inventory inventory = modelMapper.map(inventoryRequest, Inventory.class);
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }
}
