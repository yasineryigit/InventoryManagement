package com.ossovita.inventorymanagement.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Builder
public class User {

    private String username;
    private String userEmail;

}