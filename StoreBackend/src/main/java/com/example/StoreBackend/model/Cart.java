package com.example.StoreBackend.model;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Document("cart")
public class Cart {

    @Id
    private Long id;

    private LocalDateTime createdDate;


    private List<CartItem> list = new ArrayList<>();


}
