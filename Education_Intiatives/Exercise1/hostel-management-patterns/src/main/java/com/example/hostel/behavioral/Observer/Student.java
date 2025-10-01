package com.example.hostel.behavioral.Observer;

public class Student {
    private final String name;
    private final String email;

    public Student(String name, String email){
        if(name==null || email==null) 
            throw new IllegalArgumentException("Invalid student");
        this.name = name;
        this.email = email;
    }

    public void update(String roomId){
        System.out.println("Notification to " + name + " (" + email + "): Room " + roomId + " is now available!");
    }

    public String getName(){ return name; }
}
