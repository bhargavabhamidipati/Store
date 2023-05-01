package com.example.StoreBackend.repository;

import com.example.StoreBackend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {


    Product findById(long id);

    @Query("{name:'?0'}")
    Product findProductByName(String name);




    public long count();

    String deleteById(long id);
}
