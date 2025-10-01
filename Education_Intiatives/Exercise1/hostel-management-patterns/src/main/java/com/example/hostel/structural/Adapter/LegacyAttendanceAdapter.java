package com.example.hostel.structural.Adapter;

import java.util.*;
public class LegacyAttendanceAdapter implements AttendanceService {
    private final LegacyProvider legacy;
    public LegacyAttendanceAdapter(LegacyProvider legacy){ this.legacy = legacy; }
    @Override
    public List<String> getPresentStudentIds(String date){
        String csv = legacy.fetchPresent(date);
        if(csv == null || csv.trim().isEmpty()) return Collections.emptyList();
        String[] parts = csv.split(",");
        return Arrays.asList(parts);
    }
}
