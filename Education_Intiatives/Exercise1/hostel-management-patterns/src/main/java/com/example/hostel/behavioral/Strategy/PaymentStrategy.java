package com.example.hostel.behavioral.Strategy;

public interface PaymentStrategy {
    PaymentResult pay(PaymentInfo info) throws PaymentException;
}
