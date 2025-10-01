package com.example.hostel.behavioral.Strategy;

public class PaymentResult {
    public final boolean success;
    public final String transactionId;

    public PaymentResult(boolean success, String transactionId) {
        this.success = success;
        this.transactionId = transactionId;
    }
}
