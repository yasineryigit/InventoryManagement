package com.ossovita.inventorymanagement.controller;

import com.ossovita.inventorymanagement.entity.Product;
import com.ossovita.inventorymanagement.payload.request.ProductRequest;
import com.ossovita.inventorymanagement.payload.request.UpdateProductCountRequest;
import com.ossovita.inventorymanagement.payload.request.UpdateProductRequest;
import com.ossovita.inventorymanagement.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @PutMapping("/update-product")
    public Product updateProduct(@RequestBody UpdateProductRequest updateProductRequest){
        return productService.updateProduct(updateProductRequest);
    }

    @PutMapping("/update-product-count")
    public Product updateProductCount(@RequestBody UpdateProductCountRequest updateProductCountRequest) {
        return productService.updateProductCount(updateProductCountRequest);
    }

    @DeleteMapping("/delete-product-by-product-id")
    public ResponseEntity<String> deleteProductByProductId(@RequestParam long productId) {
        productService.deleteProductByProductId(productId);
        return ResponseEntity.ok("Product with ID: " + productId + " has been deleted");
    }

    @GetMapping("/get-all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get-products-by-product-name-and-warehouse-id")
    public List<Product> getProductsByProductNameAndWarehouseId(@RequestParam String productName, @RequestParam long warehouseId) {
        return productService.getProductsByProductNameAndWarehouseId(productName, warehouseId);
    }

    @GetMapping("/get-products-by-product-name-and-warehouse-address-region")
    public List<Product> getProductsByProductNameAndWarehouseAddressRegion(@RequestParam String productName, @RequestParam String addressRegion) {
        return productService.getProductsByProductNameAndWarehouseAddressRegion(productName, addressRegion);
    }

    @GetMapping("/get-products-by-product-name-and-warehouse-address-city")
    public List<Product> getProductsByProductNameAndWarehouseAddressCity(@RequestParam String productName, @RequestParam String addressCity) {
        return productService.getProductsByProductNameAndWarehouseAddressCity(productName, addressCity);
    }

    @GetMapping("/get-products-by-product-name-and-category-id")
    public List<Product> getProductsByProductNameAndCategoryId(@RequestParam String productName, @RequestParam long categoryId) {
        return productService.getProductsByProductNameAndCategoryId(productName, categoryId);
    }


}
