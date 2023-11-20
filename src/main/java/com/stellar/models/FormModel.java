package com.stellar.models;

public class FormModel {
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String phone;
    private String message;

    public FormModel(String firstName, String lastName, String email, String company, String phone, String message) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.phone = phone;
        this.message = message;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getMessage() {
        return message;
    }
}
