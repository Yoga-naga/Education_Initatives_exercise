package com.example.hostel.structural.Adapter;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        LegacyProvider legacy = new LegacyProvider();
        AttendanceService adapter = new LegacyAttendanceAdapter(legacy);
        List<String> presentIds = adapter.getPresentStudentIds(date);

        System.out.println("Present Student IDs on " + date + ": " + presentIds);
    }
}
