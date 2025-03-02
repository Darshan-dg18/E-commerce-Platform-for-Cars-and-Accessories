package com.CarEcommerse.CarEcommerse.service;

import com.CarEcommerse.CarEcommerse.model.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

@Service
public class RazorpayService {
    private final RazorpayClient razorpayClient;

    @Value("${razorpay.key.secret}")
    private String secretKey;

    public RazorpayService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    public String createOrder(Order order) throws RazorpayException {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", order.getTotalAmount().multiply(new java.math.BigDecimal(100))); // Convert to paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "order_" + order.getId());

        com.razorpay.Order razorpayOrder = razorpayClient.orders.create(orderRequest);
        return razorpayOrder.get("id");
    }

    public boolean validatePaymentSignature(String orderId, String paymentId, String razorpaySignature) {
        try {
            String data = orderId + "|" + paymentId;
            return generateSignature(data, secretKey).equals(razorpaySignature);
        } catch (Exception e) {
            return false;
        }
    }

    private String generateSignature(String data, String secret) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hmacData = mac.doFinal(data.getBytes());
        return bytesToHexString(hmacData);
    }

    private String bytesToHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}