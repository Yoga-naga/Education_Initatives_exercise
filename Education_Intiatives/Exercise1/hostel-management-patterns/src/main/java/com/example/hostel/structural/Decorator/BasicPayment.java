package com.example.hostel.structural.Decorator;

import java.util.logging.*;

public class BasicPayment implements Payment {
    private static final Logger LOG = Logger.getLogger(BasicPayment.class.getName());
    @Override
    public boolean process(double amount) {
        LOG.info("Processing core payment of " + amount);
        // simulate success
        return amount > 0;
    }
}
