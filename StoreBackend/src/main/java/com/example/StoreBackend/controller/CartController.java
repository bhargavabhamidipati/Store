package com.example.StoreBackend.controller;

import com.example.StoreBackend.model.Cart;
import com.example.StoreBackend.model.CartItem;
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

    @PostMapping("/{cartId}")
    @Operation(summary = "creates the cart")
    @ResponseStatus(HttpStatus.CREATED)
    public Cart createCart(@Parameter(description = "Id of cart to be created")@PathVariable("cartId") final Long id) {
        Cart cart = cartService.createCart(id);
        log.info("POST: Cart {}", cart);
        return cart;
    }

    @PutMapping("/addItem/{cartId}/{productId}/{quantity}/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Adds an item to the cart")
    public CartItem addCartItem(@Parameter(description = "Cart Id to which product is added")@PathVariable("cartId") Long cartId,
                                @PathVariable("productId") Long productId,
                                @PathVariable("quantity") int quantity) {
        log.info("POST: Cart {}", productId);
        return cartService.addCartItem(cartId,productId,quantity);
    }

    @PutMapping("/updateItem/{cartId}/{productId}/{quantity}/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Updates an item in the cart")
    public CartItem updateCartItem(@Parameter(description = "Cart Id to which product is added")@PathVariable("cartId") Long cartId,
                                @PathVariable("productId") Long productId,
                                @PathVariable("quantity") int quantity) {
        log.info("POST: Cart {}", productId);
        CartItem cartItem = cartService.getCartItemToUpdate(cartId,productId);
        cartItem.setQuantity(quantity);
        return cartService.UpdateCart(cartItem);

    }

    @DeleteMapping("/cartItems/{cartId}/{productId}")
    @Operation(summary = "Deletes the given item")
    @ResponseStatus(HttpStatus.OK)
    public Long removeCartItem(@PathVariable("cartId") Long cartId, @PathVariable("productId") Long productId) {
        log.info("DELETE: CartItem {}", cartId);
        cartService.removeCartItem(cartId,productId);
        return productId;
    }

    @DeleteMapping("/{cartId}/")
    @Operation(summary = "Clears the cart")
    public Long clearCart(@PathVariable("cartId") Long cartId) {
        log.info("DELETE: Product {}", cartId);
        cartService.clearCart(cartId);
        return cartId;
    }

    @GetMapping("/cartItems/{cartId}")
    @Operation(summary = "Get all cart items")
    public List<CartItem> getAllCartItems(@PathVariable("cartId") Long cartId) {
        log.info("GET: All cartItems");
        return cartService.getAllCartItems(cartId);

    }



}
