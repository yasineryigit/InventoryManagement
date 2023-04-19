package com.ossovita.inventorymanagement.payload.request;

import lombok.Data;

@Data
public class ProductRequest {


    private long categoryId;
    private long inventoryId;
    private String productName;
    private int productCount;
    private int productAlertCount;

}
