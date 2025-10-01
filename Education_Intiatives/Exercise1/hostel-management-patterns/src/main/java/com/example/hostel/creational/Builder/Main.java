package com.example.hostel.creational.Builder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String roll = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        try {
            StudentProfile profile = new StudentProfile.Builder()
                    .name(name)
                    .email(email)
                    .rollNumber(roll)
                    .phone(phone)
                    .address(address)
                    .build();

            System.out.println(" Student Profile Created:");
            System.out.println(profile);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
