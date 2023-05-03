package edu.guilford;

import java.util.Random;

public class Individual implements Comparable<Individual> {
    // Three attributes for name, email, and phone
    protected FullName name;
    protected String email;
    protected String phone;
    private Random rand = new Random();

    // Constructor that gives default data
    public Individual() {
        // Set the name attribute to "John Doe"
        name = new FullName();
        // Set the email attribute to "jdoe@guilford"
        email = (name.getFirstName().charAt(0) + name.getLastName() + "@guilford.edu")
        .toLowerCase();
        // Set the phone attribute to a random value of the form ###-###-####
        phone = String.format("%03d-%03d-%04d", rand.nextInt(1000), rand.nextInt(1000), rand.nextInt(10000));
    }

    // Constructor that takes three String parameters
    public Individual(FullName name, String email, String phone) {
        // Set the name attribute to the name parameter
        this.name = name;
        // Set the email attribute to the email parameter
        this.email = email;
        // Set the phone attribute to the phone parameter
        this.phone = phone;
    }

    // getters and setters
    // getter for name
    public FullName getName() {
        // return the name attribute
        return name;
    }

    // setter for name
    public void setName(FullName name) {
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

    @Override
    public int compareTo(Individual o) {
        // Use name for comparison
        return name.compareTo(o.name);
    }
    

}
