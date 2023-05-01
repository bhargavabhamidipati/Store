package com.example.StoreBackend.repository;

import com.example.StoreBackend.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends MongoRepository<Cart, String> {


    Cart findById(Long id);

    //String deleteById(Long cartId);
}
