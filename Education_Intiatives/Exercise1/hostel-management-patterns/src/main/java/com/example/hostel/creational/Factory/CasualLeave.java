package com.example.hostel.creational.Factory;

public class CasualLeave implements LeaveRequest {
    private final String reason;
    public CasualLeave(String reason){ this.reason = reason; }
    @Override public String getType(){ return "CASUAL"; }
    @Override public boolean validate(){ return reason != null; }
}
