package com.example.hostel.behavioral.Strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Payer ID: ");
        String payerId = sc.nextLine();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume leftover newline

        System.out.print("Enter Details: ");
        String details = sc.nextLine();

        try {
            PaymentInfo info = new PaymentInfo(payerId, amount, details);

            PaymentStrategy strategy = new GPayStrategy();
            PaymentProcessor processor = new PaymentProcessor(strategy);

            PaymentResult result = processor.pay(info);

            System.out.println("Payment Success: " + result.success);
            System.out.println("Transaction ID: " + result.transactionId);
        } catch (Exception e) {
            System.err.println("Payment failed: " + e.getMessage());
        }
    }
}
