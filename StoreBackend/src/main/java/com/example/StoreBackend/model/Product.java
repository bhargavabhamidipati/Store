package com.example.StoreBackend.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("products")
@Data
@Builder
public class Product {

    @Id
    private long id;

    private String category;
    private String name;
    private double price;
    private String description;
    private LocalDateTime updatedAt;

}
