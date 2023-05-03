package edu.guilford;

import java.util.Random;

public class NonExemptEmployee {
    private double hourlyRate;
    private double hoursWorked;
    private Random rand = new Random();

    public NonExemptEmployee() {
        hourlyRate = rand.nextDouble(7.25, 100.00);
        hoursWorked = rand.nextDouble(0.0, 70.0);
    }

    public NonExemptEmployee(double hourlyRate, double hoursWorked) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) throws BadHourlyRateException {
        if (hourlyRate >= 7.25 && hourlyRate <= 100.00) {
            this.hourlyRate = hourlyRate;
        } else {
            throw new BadHourlyRateException("Hourly rate must be between $7.25 and $100.00");
        }
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) throws BadHoursWorkedException {
        if (hoursWorked >= 0.0 && hoursWorked <= 168.0) {
            this.hoursWorked = hoursWorked;
        } else {
            throw new BadHoursWorkedException("Hours worked must be between 0.0 and 168.0");
        }
    }

    public double getGrossPay() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", getHourlyRate(), getHoursWorked(), getGrossPay());
    }
}
