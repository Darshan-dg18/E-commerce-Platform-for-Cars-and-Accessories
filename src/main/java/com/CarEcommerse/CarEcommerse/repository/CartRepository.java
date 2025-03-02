package com.CarEcommerse.CarEcommerse.repository;

import com.CarEcommerse.CarEcommerse.model.Cart;
import com.CarEcommerse.CarEcommerse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}