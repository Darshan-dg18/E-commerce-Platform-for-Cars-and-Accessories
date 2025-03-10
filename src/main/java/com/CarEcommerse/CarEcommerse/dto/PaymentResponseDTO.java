package com.CarEcommerse.CarEcommerse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDTO {
    private String orderId;
    private String status;
    private String message;
    private String paymentId;
    private String razorpayOrderId;
}