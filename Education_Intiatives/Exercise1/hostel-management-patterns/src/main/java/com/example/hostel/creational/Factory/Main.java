package com.example.hostel.creational.Factory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Leave Type (1 = SICK, 2 = CASUAL): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Reason/Details: ");
        String input = sc.nextLine();

        try {
            LeaveRequest request;
            if (choice == 1) {
                request = LeaveRequestFactory.create(LeaveRequestFactory.Type.SICK, input);
            } else if (choice == 2) {
                request = LeaveRequestFactory.create(LeaveRequestFactory.Type.CASUAL, input);
            } else {
                throw new IllegalArgumentException("Invalid choice");
            }

            System.out.println("Leave Type: " + request.getType());
            System.out.println("Validation Passed: " + request.validate());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
