package com.ossovita.inventorymanagement.payload.request;

import lombok.Data;

@Data
public class UpdateProductRequest {

    private long productId;
    private String productName;
    private int productCount;
    private int productAlertCount;

}
