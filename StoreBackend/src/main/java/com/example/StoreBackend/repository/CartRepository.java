package com.example.StoreBackend.repository;

import com.example.StoreBackend.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends MongoRepository<Cart, String> {

    @Query("{id:'?0'}")
    Cart findCartById(Long id);


}
