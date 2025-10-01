package com.example.hostel.structural.Decorator;

public class ValidationDecorator extends PaymentDecorator {
    public ValidationDecorator(Payment wrapped){ super(wrapped); }
    @Override
    public boolean process(double amount){
        if(amount <= 0) throw new IllegalArgumentException("Invalid amount");
        return wrapped.process(amount);
    }
}
