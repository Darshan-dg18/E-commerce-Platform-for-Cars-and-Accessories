package com.CarEcommerse.CarEcommerse.controller;

import com.CarEcommerse.CarEcommerse.model.Order;
import com.CarEcommerse.CarEcommerse.model.OrderStatus;
import com.CarEcommerse.CarEcommerse.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder() {
        return ResponseEntity.ok(orderService.createOrder());
    }

    @GetMapping
    public ResponseEntity<List<Order>> getUserOrders() {
        return ResponseEntity.ok(orderService.getUserOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Order> updateOrderStatus(
            @PathVariable Long id,
            @RequestParam OrderStatus status
    ) {
        return ResponseEntity.ok(orderService.updateOrderStatus(id, status));
    }
}