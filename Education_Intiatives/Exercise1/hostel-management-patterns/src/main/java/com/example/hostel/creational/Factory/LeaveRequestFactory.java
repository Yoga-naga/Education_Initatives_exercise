package com.example.hostel.creational.Factory;

public class LeaveRequestFactory {
    public enum Type { SICK, CASUAL }
    public static LeaveRequest create(Type type, String payload){
        switch(type){
            case SICK: return new SickLeave(payload);
            case CASUAL: return new CasualLeave(payload);
            default: throw new IllegalArgumentException("Unknown type");
        }
    }
}
