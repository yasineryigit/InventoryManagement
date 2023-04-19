package com.ossovita.inventorymanagement.service.impl;

import com.ossovita.inventorymanagement.email.EmailService;
import com.ossovita.inventorymanagement.entity.History;
import com.ossovita.inventorymanagement.entity.Product;
import com.ossovita.inventorymanagement.entity.ProductCategory;
import com.ossovita.inventorymanagement.entity.ProductInventory;
import com.ossovita.inventorymanagement.error.exception.ProductNotFoundException;
import com.ossovita.inventorymanagement.error.exception.UnsufficientProductCountException;
import com.ossovita.inventorymanagement.payload.request.ProductRequest;
import com.ossovita.inventorymanagement.payload.request.UpdateProductCountRequest;
import com.ossovita.inventorymanagement.payload.request.UpdateProductRequest;
import com.ossovita.inventorymanagement.repository.HistoryRepository;
import com.ossovita.inventorymanagement.repository.ProductCategoryRepository;
import com.ossovita.inventorymanagement.repository.ProductInventoryRepository;
import com.ossovita.inventorymanagement.repository.ProductRepository;
import com.ossovita.inventorymanagement.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@Transactional
public class ProductServiceImpl implements ProductService {

    ModelMapper modelMapper;
    ProductRepository productRepository;
    ProductCategoryRepository productCategoryRepository;
    ProductInventoryRepository productInventoryRepository;
    HistoryRepository historyRepository;
    EmailService emailService;

    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, ProductInventoryRepository productInventoryRepository, HistoryRepository historyRepository, EmailService emailService) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.productInventoryRepository = productInventoryRepository;
        this.historyRepository = historyRepository;
        this.emailService = emailService;
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        //Save Product
        Product product = modelMapper.map(productRequest, Product.class);
        Product savedProduct = productRepository.save(product);
        saveHistory(product, "Create product");

        //Save ProductCategory
        ProductCategory productCategory = ProductCategory.builder()
                .productId(savedProduct.getProductId())
                .categoryId(productRequest.getCategoryId()).build();

        productCategoryRepository.save(productCategory);

        //Save ProductInventory
        ProductInventory productInventory = ProductInventory.builder()
                .productId(savedProduct.getProductId())
                .inventoryId(productRequest.getInventoryId()).build();

        productInventoryRepository.save(productInventory);

        return savedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProductCount(UpdateProductCountRequest updateProductCountRequest) {
        Product product = productRepository.findById(updateProductCountRequest.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found by given id : " + updateProductCountRequest.getProductId()));

        int updatedProductCount = product.getProductCount() - updateProductCountRequest.getNumberOfProductsToBeRemoved();

        if (updatedProductCount < 0) {//if productCount is unsufficient,  show error
            log.error("Unsufficient product count for productId: " + product.getProductId() + " productName:" + product.getProductName());
            throw new UnsufficientProductCountException("Unsufficient product count for productId: " + product.getProductId() + ", productName:" + product.getProductName());
        } else {//if stocks are sufficient, continue
            product.setProductCount(updatedProductCount);
            if (updatedProductCount <= product.getProductAlertCount()) {//if productCount is below critical number, alert user
                emailService.sendAlertMail(product);
                log.error("Product: " + product.getProductName() + " below alert count: " + updatedProductCount);
            }
            saveHistory(product, "Update product count: " + updatedProductCount);
            return productRepository.save(product);

        }


    }

    @Override
    public List<Product> getProductsByProductNameAndWarehouseId(String productName, long warehouseId) {
        return productRepository.getProductsByProductNameAndWarehouseId(productName, warehouseId);
    }

    @Override
    public List<Product> getProductsByProductNameAndWarehouseAddressCity(String productName, String addressCity) {
        return productRepository.getProductsByProductNameAndWarehouseAddressCity(productName, addressCity);
    }

    @Override
    public List<Product> getProductsByProductNameAndCategoryId(String productName, long categoryId) {
        return productRepository.getProductsByProductNameAndCategoryId(productName, categoryId);
    }

    @Override
    public void deleteProductByProductId(long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found by given id: " + productId));
        productInventoryRepository.deleteByProductId(productId);
        productCategoryRepository.deleteByProductId(productId);
        productRepository.delete(product);
        saveHistory(product, "Delete product ");
    }

    @Override
    public Product updateProduct(UpdateProductRequest updateProductRequest) {
        //get Product from database
        Product product = productRepository.findById(updateProductRequest.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found by given id : " + updateProductRequest.getProductId()));

        //update Product
        product.setProductName(updateProductRequest.getProductName());
        product.setProductCount(updateProductRequest.getProductCount());
        product.setProductAlertCount(updateProductRequest.getProductAlertCount());
        saveHistory(product, "Update product");
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByProductNameAndWarehouseAddressRegion(String productName, String addressRegion) {
        return productRepository.getProductsByProductNameAndWarehouseAddressRegion(productName, addressRegion);
    }

    public void saveHistory(Product product, String operation) {
        History history = History.builder().productId(product.getProductId())
                .operation(operation)
                .dateTime(LocalDateTime.now())
                .build();
        historyRepository.save(history);

    }


}
