package edu.guilford;

import java.util.Random;

public class ExemptEmployee extends Individual {

    private double salary;
    private Random rand = new Random();

    public ExemptEmployee() {
        super();
        salary = rand.nextDouble(40000, 250000);
    }

    public ExemptEmployee(FullName name, String email, String phone, double salary) {
        super(name, email, phone);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws BadSalaryException {
        if (salary >= 40000 && salary <= 250000) {
            this.salary = salary;
        } else {
            throw new BadSalaryException("Salary must be between $40,000 and $250,000");
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", getName(), getEmail(), getPhone(), getSalary());
    }

}
