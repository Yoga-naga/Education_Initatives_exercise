package com.example.hostel.behavioral.Strategy;

public class PaymentInfo {
    public final String payerId;
    public final double amount;
    public final String details;

    public PaymentInfo(String payerId, double amount, String details) {
        if (payerId == null || amount <= 0)
            throw new IllegalArgumentException("Invalid payment");
        this.payerId = payerId;
        this.amount = amount;
        this.details = details;
    }
}
