package com.ossovita.inventorymanagement.service;

import com.ossovita.inventorymanagement.entity.Product;
import com.ossovita.inventorymanagement.payload.request.ProductRequest;
import com.ossovita.inventorymanagement.payload.request.UpdateProductCountRequest;
import com.ossovita.inventorymanagement.payload.request.UpdateProductRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest productRequest);

    List<Product> getAllProducts();

    Product updateProductCount(UpdateProductCountRequest updateProductCountRequest);

    List<Product> getProductsByProductNameAndWarehouseAddressRegion(String productName, String addressRegion);

    List<Product> getProductsByProductNameAndWarehouseId(String productName, long warehouseId);

    List<Product> getProductsByProductNameAndWarehouseAddressCity(String productName, String addressCity);

    List<Product> getProductsByProductNameAndCategoryId(String productName, long categoryId);

    void deleteProductByProductId(long productId);

    Product updateProduct(UpdateProductRequest updateProductRequest);
}
