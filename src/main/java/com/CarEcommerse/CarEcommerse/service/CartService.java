package com.CarEcommerse.CarEcommerse.service;

import com.CarEcommerse.CarEcommerse.exception.ResourceNotFoundException;
import com.CarEcommerse.CarEcommerse.model.Cart;
import com.CarEcommerse.CarEcommerse.model.User;

import com.CarEcommerse.CarEcommerse.repository.CartRepository;
import com.CarEcommerse.CarEcommerse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserService userService;

    public CartService(CartRepository cartRepository, UserService userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    @Transactional
    public Cart getOrCreateCart(User user) {
        return cartRepository.findByUser(user)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });
    }

    @Transactional
    public Cart addItemToCart(Long carId, Integer quantity) {
        User currentUser = userService.getCurrentUser();
        Cart cart = getOrCreateCart(currentUser);

        // Add implementation for adding items to cart
        return cartRepository.save(cart);
    }

    @Transactional
    public Cart removeItemFromCart(Long cartItemId) {
        User currentUser = userService.getCurrentUser();
        Cart cart = getOrCreateCart(currentUser);

        // Add implementation for removing items from cart
        return cartRepository.save(cart);
    }

    public Cart getCart() {
        User currentUser = userService.getCurrentUser();
        return cartRepository.findByUser(currentUser)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
    }
}