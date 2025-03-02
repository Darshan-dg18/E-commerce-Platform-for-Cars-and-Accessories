package com.CarEcommerse.CarEcommerse.service;


import com.CarEcommerse.CarEcommerse.exception.ResourceNotFoundException;
import com.CarEcommerse.CarEcommerse.model.Order;
import com.CarEcommerse.CarEcommerse.model.Payment;
import com.CarEcommerse.CarEcommerse.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Payment createPayment(Order order) {
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(order.getTotalAmount());
        payment.setPaymentMethod("RAZORPAY");
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus("PENDING");

        return paymentRepository.save(payment);
    }

    @Transactional
    public Payment updatePaymentStatus(String orderId, String status, String transactionId) {
        Payment payment = paymentRepository.findByOrderId(Long.parseLong(orderId))
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found for order: " + orderId));

        payment.setStatus(status);
        payment.setTransactionId(transactionId);
        return paymentRepository.save(payment);
    }
}