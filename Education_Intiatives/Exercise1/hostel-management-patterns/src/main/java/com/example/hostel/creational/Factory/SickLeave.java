package com.example.hostel.creational.Factory;

public class SickLeave implements LeaveRequest {
    private final String details;
    public SickLeave(String details){ this.details = details; }
    @Override public String getType(){ return "SICK"; }
    @Override public boolean validate(){ return details != null && details.length() > 3; }
}
