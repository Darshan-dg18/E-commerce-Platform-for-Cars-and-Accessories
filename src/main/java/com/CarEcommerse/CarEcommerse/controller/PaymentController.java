package com.CarEcommerse.CarEcommerse.controller;

import com.CarEcommerse.CarEcommerse.model.Order;
import com.CarEcommerse.CarEcommerse.service.OrderService;
import com.CarEcommerse.CarEcommerse.service.PaymentService;
import com.CarEcommerse.CarEcommerse.service.RazorpayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;
    private final OrderService orderService;
    private final RazorpayService razorpayService;

    public PaymentController(PaymentService paymentService, OrderService orderService, RazorpayService razorpayService) {
        this.paymentService = paymentService;
        this.orderService = orderService;
        this.razorpayService = razorpayService;
    }

    @PostMapping("/create-order")
    public ResponseEntity<String> createRazorpayOrder(@RequestParam Long orderId) {
        try {
            Order order = orderService.getOrderById(orderId);
            String razorpayOrderId = razorpayService.createOrder(order);
            return ResponseEntity.ok(razorpayOrderId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyPayment(
            @RequestBody Map<String, String> paymentDetails
    ) {
        String orderId = paymentDetails.get("razorpay_order_id");
        String paymentId = paymentDetails.get("razorpay_payment_id");
        String signature = paymentDetails.get("razorpay_signature");

        boolean isValid = razorpayService.validatePaymentSignature(orderId, paymentId, signature);

        if (isValid) {
            // Update payment status
            paymentService.updatePaymentStatus(orderId, "SUCCESS", paymentId);
            return ResponseEntity.ok("Payment processed successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid payment signature");
        }
    }
}