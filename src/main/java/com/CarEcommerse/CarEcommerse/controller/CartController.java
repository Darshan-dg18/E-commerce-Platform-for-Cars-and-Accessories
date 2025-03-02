package com.CarEcommerse.CarEcommerse.controller;

import com.CarEcommerse.CarEcommerse.model.Cart;
import com.CarEcommerse.CarEcommerse.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<Cart> getCart() {
        return ResponseEntity.ok(cartService.getCart());
    }

    @PostMapping("/items")
    public ResponseEntity<Cart> addItemToCart(
            @RequestParam Long carId,
            @RequestParam Integer quantity
    ) {
        return ResponseEntity.ok(cartService.addItemToCart(carId, quantity));
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long itemId) {
        return ResponseEntity.ok(cartService.removeItemFromCart(itemId));
    }
}