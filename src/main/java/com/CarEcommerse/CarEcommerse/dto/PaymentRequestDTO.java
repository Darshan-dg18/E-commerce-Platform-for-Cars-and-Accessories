package com.CarEcommerse.CarEcommerse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDTO {
    private Long orderId;
    private String paymentMethod;
    private String currency;

    // Razorpay callback fields
    private String razorpayOrderId;
    private String razorpayPaymentId;
    private String razorpaySignature;
}