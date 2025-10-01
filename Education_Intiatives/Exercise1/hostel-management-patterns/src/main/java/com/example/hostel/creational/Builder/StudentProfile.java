package com.example.hostel.creational.Builder;

public class StudentProfile {
    private final String name;
    private final String email;
    private final String rollNumber;
    private final String phone;
    private final String address;

    private StudentProfile(Builder b) {
        this.name = b.name;
        this.email = b.email;
        this.rollNumber = b.rollNumber;
        this.phone = b.phone;
        this.address = b.address;
    }

    // ✅ Builder must be public static
    public static class Builder {
        private String name, email, rollNumber, phone, address;

        public Builder name(String name) { this.name = name; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder rollNumber(String r) { this.rollNumber = r; return this; }
        public Builder phone(String phone) { this.phone = phone; return this; }
        public Builder address(String a) { this.address = a; return this; }

        public StudentProfile build() {
            if (name == null || email == null)
                throw new IllegalStateException("name and email required");
            return new StudentProfile(this);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Student[name=%s,email=%s,roll=%s,phone=%s,address=%s]",
                name, email, rollNumber, phone, address
        );
    }
}
