package com.example.StoreBackend.model;


import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("CartItems")
public class CartItem {

    @Id
    private Long id;

    private Long productId;

    private int quantity;
}
