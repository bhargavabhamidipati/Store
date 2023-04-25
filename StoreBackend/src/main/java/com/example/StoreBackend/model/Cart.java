package com.example.StoreBackend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.HashSet;
import java.util.Set;

@Data
@Document("cart")
public class Cart {

    private Long id;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> cartItems = new HashSet<>();

    public void addCartItem(CartItem cartItem){
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }

    public void removecartItem(CartItem cartItem){
        cartItems.remove(cartItem);
        cartItem.setCart(null);
    }

    public void clearcartItems(){
        for(CartItem cartItem : cartItems){
            cartItem.setCart(null);
        }
        cartItems.clear();
    }


}
