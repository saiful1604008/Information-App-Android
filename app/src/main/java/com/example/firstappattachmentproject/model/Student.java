package com.example.firstappattachmentproject.model;

public class Student {

    private String name;
    private String password;
    private String email;
    private Float cgpa;
    private String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\n"+
                "Email: "+email+"\n"+
                "CGPA: "+cgpa+"\n"+
                "Contact No: "+contact;

    }
}
