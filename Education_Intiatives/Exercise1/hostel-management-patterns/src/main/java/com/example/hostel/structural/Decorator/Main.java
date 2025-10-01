package com.example.hostel.structural.Decorator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter payment amount: ");
        double amount = sc.nextDouble();

        try {
            // core payment
            Payment payment = new BasicPayment();

            // add decorators
            payment = new ValidationDecorator(payment);
            payment = new LoggingDecorator(payment);

            boolean success = payment.process(amount);

            System.out.println("Payment success: " + success);

        } catch (Exception e) {
            System.err.println("Payment failed: " + e.getMessage());
        }
    }
}
