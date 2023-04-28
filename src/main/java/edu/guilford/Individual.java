package edu.guilford;

public class Individual {
    // Three attributes for name, email, and phone
    private String name;
    private String email;
    private String phone;

    // Constructor that gives default data
    public Individual() {
        // Set the name attribute to "John Doe"
        name = "John Doe";
        // Set the email attribute to "jdoe@guilford"
        email = "jdoe@guilford";
        // Set the phone attribute to "555-555-5555"
        phone = "555-555-5555";
    }

    // Constructor that takes three String parameters
    public Individual(String name, String email, String phone) {
        // Set the name attribute to the name parameter
        this.name = name;
        // Set the email attribute to the email parameter
        this.email = email;
        // Set the phone attribute to the phone parameter
        this.phone = phone;
    }

    // getters and setters
    // getter for name
    public String getName() {
        // return the name attribute
        return name;
    }

    // setter for name
    public void setName(String name) {
        // set the name attribute to the name parameter
        this.name = name;
    }

    // getter for email
    public String getEmail() {
        // return the email attribute
        return email;
    }

    // setter for email
    public void setEmail(String email) {
        // set the email attribute to the email parameter
        this.email = email;
    }

    // getter for phone
    public String getPhone() {
        // return the phone attribute
        return phone;
    }   

    // setter for phone
    public void setPhone(String phone) {
        // set the phone attribute to the phone parameter
        this.phone = phone;
    }

    // toString method
    @Override
    public String toString() {
        // return a String representation of the object
        return "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone;
    }
    

}
