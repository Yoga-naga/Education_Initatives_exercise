package com.example.hostel.structural.Decorator;

public abstract class PaymentDecorator implements Payment {
    protected final Payment wrapped;
    protected PaymentDecorator(Payment wrapped){
        if(wrapped==null) throw new IllegalArgumentException("wrapped required");
        this.wrapped = wrapped;
    }
}
