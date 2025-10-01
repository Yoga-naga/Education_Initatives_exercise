package com.example.hostel.behavioral.Strategy;

import java.util.logging.*;

public class PaymentProcessor {
    private static final Logger LOG = Logger.getLogger(PaymentProcessor.class.getName());
    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(PaymentStrategy strategy) {
        if (strategy == null) throw new IllegalArgumentException("Strategy required");
        this.strategy = strategy;
        LOG.info("Payment strategy set: " + strategy.getClass().getSimpleName());
    }

    public PaymentResult pay(PaymentInfo info) throws PaymentException {
        return strategy.pay(info);
    }
}
