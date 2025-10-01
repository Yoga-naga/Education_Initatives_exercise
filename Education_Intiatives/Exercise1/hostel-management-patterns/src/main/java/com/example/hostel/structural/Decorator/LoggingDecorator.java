package com.example.hostel.structural.Decorator;

import java.util.logging.*;

public class LoggingDecorator extends PaymentDecorator {
    private static final Logger LOG = Logger.getLogger(LoggingDecorator.class.getName());
    public LoggingDecorator(Payment wrapped){ super(wrapped); }
    @Override
    public boolean process(double amount){
        LOG.info("Before payment: amount=" + amount);
        boolean res = wrapped.process(amount);
        LOG.info("After payment: success=" + res);
        return res;
    }
}
