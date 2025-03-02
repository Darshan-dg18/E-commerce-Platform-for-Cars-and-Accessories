package com.CarEcommerse.CarEcommerse.service;

import com.CarEcommerse.CarEcommerse.exception.ResourceNotFoundException;
import com.CarEcommerse.CarEcommerse.model.Order;
import com.CarEcommerse.CarEcommerse.model.OrderStatus;
import com.CarEcommerse.CarEcommerse.model.User;
import com.CarEcommerse.CarEcommerse.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final CartService cartService;

    public OrderService(OrderRepository orderRepository, UserService userService, CartService cartService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.cartService = cartService;
    }

    @Transactional
    public Order createOrder() {
        User currentUser = userService.getCurrentUser();
        // Add implementation for creating order from cart
        return null;
    }

    public List<Order> getUserOrders() {
        User currentUser = userService.getCurrentUser();
        return orderRepository.findByUser(currentUser);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    }

    @Transactional
    public Order updateOrderStatus(Long id, OrderStatus status) {
        Order order = getOrderById(id);
        order.setStatus(status);
        return orderRepository.save(order);
    }
}