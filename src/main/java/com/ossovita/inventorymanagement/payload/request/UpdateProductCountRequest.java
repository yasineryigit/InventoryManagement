package com.ossovita.inventorymanagement.payload.request;

import lombok.Data;

@Data
public class UpdateProductCountRequest {

    private long productId;
    private int numberOfProductsToBeRemoved;
}
