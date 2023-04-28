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
import java.util.Set;

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
        return cartRepository.findCartById(cartId);
    }

    /**public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }**/

    public Cart createCart(Long id) {
        Cart cart = new Cart();
        cart.setId(id);
        return cartRepository.save(cart);
    }

    public CartItem addCartItem(Long cartId, Product product, int quantity) {
        Cart cart = getCartById(cartId);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setCart(cart);
        return cartItemRepository.save(cartItem);
    }

    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public Set<CartItem> getCartItemsByCartId(Long cartId) {
        Cart cart = cartRepository.findCartById(cartId);
        return cart.getCartItems();
    }

    public void clearCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
