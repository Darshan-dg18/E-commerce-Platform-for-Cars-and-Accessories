package com.CarEcommerse.CarEcommerse.repository;

import com.CarEcommerse.CarEcommerse.model.Order;
import com.CarEcommerse.CarEcommerse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}