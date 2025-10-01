package com.example.hostel.behavioral.Observer;

import java.util.Scanner;

public class ObserverDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoomManager rm = new RoomManager();

        System.out.print("Enter number of students to register: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter student email: ");
            String email = sc.nextLine();

            Student s = new Student(name, email);
            rm.registerObserver(s);
        }

        while (true) {
            System.out.print("Enter room to add (or type 'exit' to quit): ");
            String roomId = sc.nextLine();
            if (roomId.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program...");
                break;
            }
            rm.addAvailableRoom(roomId);
        }

        sc.close();
    }
}
