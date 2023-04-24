package com.example.StoreBackend.service;


import com.example.StoreBackend.model.Product;
import com.example.StoreBackend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        product.setUpdatedAt(LocalDateTime.now());
        return repository.save(product);
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product getProductById(Long id){
        return repository.findProductById(id);
    }

    public String deleteProduct(Long id){
        return repository.deleteById(id);
    }

}
