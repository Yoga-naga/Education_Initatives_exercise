package com.example.hostel.behavioral.Strategy;

import java.util.UUID;
import java.util.logging.*;

public class GPayStrategy implements PaymentStrategy {
    private static final Logger LOG = Logger.getLogger(GPayStrategy.class.getName());

    @Override
    public PaymentResult pay(PaymentInfo info) throws PaymentException {
        LOG.info("Processing GPay for " + info.payerId);
        // simulate success
        return new PaymentResult(true, "GPAY-" + UUID.randomUUID());
    }
}
