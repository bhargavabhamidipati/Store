package com.example.StoreBackend.repository;

import com.example.StoreBackend.model.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends MongoRepository<CartItem, String> {

    @Query("{id: '?0'}")
    CartItem findCartItemById();

    public long count();

    String deleteById(Long id);
}
