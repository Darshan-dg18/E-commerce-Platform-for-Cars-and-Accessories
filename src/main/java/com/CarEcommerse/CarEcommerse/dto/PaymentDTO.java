package com.CarEcommerse.CarEcommerse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Long id;
    private Long orderId;
    private BigDecimal amount;
    private String paymentMethod;
    private String transactionId;
    private LocalDateTime paymentDate;
    private String status;

    // Razorpay specific fields
    private String razorpayOrderId;
    private String razorpayPaymentId;
    private String razorpaySignature;
}