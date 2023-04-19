package com.ossovita.inventorymanagement.service.impl;

import com.ossovita.inventorymanagement.payload.request.WarehouseRequest;
import com.ossovita.inventorymanagement.entity.Address;
import com.ossovita.inventorymanagement.entity.Warehouse;
import com.ossovita.inventorymanagement.repository.AddressRepository;
import com.ossovita.inventorymanagement.repository.WarehouseRepository;
import com.ossovita.inventorymanagement.service.WarehouseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    WarehouseRepository warehouseRepository;

    AddressRepository addressRepository;

    ModelMapper modelMapper;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository, AddressRepository addressRepository, ModelMapper modelMapper) {
        this.warehouseRepository = warehouseRepository;
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Warehouse createWarehouse(WarehouseRequest warehouseRequest) {
        Address address = modelMapper.map(warehouseRequest, Address.class);
        Address savedAddress = addressRepository.save(address);

        Warehouse warehouse = modelMapper.map(warehouseRequest, Warehouse.class);
        warehouse.setAddressId(savedAddress.getAddressId());

        return warehouseRepository.save(warehouse);

    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public List<Warehouse> getByProductName(String productName) {
        return warehouseRepository.findWarehousesByProductName(productName);
    }


}
