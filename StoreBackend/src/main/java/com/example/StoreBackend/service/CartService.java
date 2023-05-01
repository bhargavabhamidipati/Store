package com.example.StoreBackend.service;

import com.example.StoreBackend.model.Cart;
import com.example.StoreBackend.model.CartItem;
import com.example.StoreBackend.model.Product;
import com.example.StoreBackend.repository.CartItemRepository;
import com.example.StoreBackend.repository.CartRepository;
import com.example.StoreBackend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId);
    }



    public Cart createCart(Long cartId) {
        Cart cart = new Cart();
        cart.setId(cartId);
        return cartRepository.save(cart);
    }

    public CartItem addCartItem(Long cartId, Long productId, int quantity) {
        Cart cart = cartRepository.findById(cartId);
        CartItem cartItem = new CartItem();
        cartItem.setId(cartId);
        cartItem.setQuantity(quantity);
        cartItem.setProductId(productId);
        return cartItemRepository.save(cartItem);
    }
    public CartItem UpdateCart(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }

    public CartItem getCartItemToUpdate(Long cartId, Long productId){
        return cartItemRepository.findByCartIdAndProductId(cartId,productId);
    }

    public void removeCartItem(Long cartId, Long productId) {
        cartItemRepository.deleteByCartIdAndProductId(cartId,productId);
    }

    public List<CartItem> getAllCartItems(Long cartId) {
        return cartItemRepository.findById(cartId);
    }

    public void clearCart(Long cartId) {
        cartItemRepository.deleteById(cartId);
    }
}
