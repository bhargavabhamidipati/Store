package com.example.StoreBackend.controller;

import com.example.StoreBackend.model.Cart;
import com.example.StoreBackend.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{cartId}")
    @Operation(summary = "gets the cart")
    public Cart getCartById(@Parameter(description = "Id of cart to get the cart")@PathVariable("cartId") final Long cartId) {
        return cartService.getCartById(cartId);
    }

    /**
    public List<Cart> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        return ResponseEntity.ok(carts);
    }**/

    @PostMapping("/{cartId}")
    @Operation(summary = "creates the cart")
    @ResponseStatus(HttpStatus.CREATED)
    public Cart createCart(@Parameter(description = "Id of cart to be created")@PathVariable("cartId") final Long id) {
        Cart cart = cartService.createCart(id);
        log.info("POST: Cart {}", cart);
        return cart;
    }

    @PostMapping("/{cartId}/cartItems")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Adds an item to the cart")
    public CartItem addCartItem(@Parameter(description = "Cart Id to which product is added")@PathVariable("cartId") Long cartId, @RequestBody CartItem cartItem) {
        log.info("POST: Cart {}", cartItem);
        return cartService.addCartItem(cartId,cartItem.getProduct(),cartItem.getQuantity());
    }

    @DeleteMapping("/cartItems/{cartItemId}")
    @Operation(summary = "Deletes the given item")
    @ResponseStatus(HttpStatus.OK)
    public Long removeCartItem(@PathVariable("cartItemId") Long cartItemId) {
        log.info("DELETE: CartItem {}", cartItemId);
        cartService.removeCartItem(cartItemId);
        return cartItemId;
    }

    @GetMapping("/cartItems")
    @Operation(summary = "Get all cart items")
    public List<CartItem> getAllCartItems() {
        log.info("GET: All cartItems");
        return cartService.getAllCartItems();

    }

    @GetMapping("/{cartId}/cartItems")
    @Operation(summary = "Get all cart items using cartId")
    public Set<CartItem> getCartItemsByCartId(@PathVariable("cartId") Long cartId) {
        log.info("GET: All cartItems");
        return cartService.getCartItemsByCartId(cartId);
    }

    @DeleteMapping("/{cartId}/cartItems")
    public Long clearCart(@PathVariable("cartId") Long cartId) {
        log.info("DELETE: Product {}", cartId);
        cartService.clearCart(cartId);
        return cartId;
    }

}
