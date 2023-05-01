package com.example.StoreBackend.repository;

import com.example.StoreBackend.model.CartItem;
import com.example.StoreBackend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends MongoRepository<CartItem,String> {


    List<CartItem> findById(Long cartId);

    @Query("{'id' : ?0, 'productId' : ?1}")
    CartItem findByCartIdAndProductId(Long cartId, Long productId);

    @Query("{'id' : ?0, 'productId' : ?1}")
    void deleteByCartIdAndProductId(Long cartId, Long productId);


    void deleteById(Long cartId);
}
