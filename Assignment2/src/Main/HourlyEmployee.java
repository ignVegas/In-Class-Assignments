package Main;

public class HourlyEmployee extends Employee {
    private double wage;
    private double hoursWorked;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,double wage,double hoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        if(wage < 0.0) throw new IllegalArgumentException("Wage must be >= 0");
        this.wage = wage;
        if(hoursWorked < 0.0 || hoursWorked > 168.0) throw new IllegalArgumentException("Wrong hours input!");
        this.hoursWorked = hoursWorked;

    }

    public void setWage(double wage) {
        if(wage < 0.0) throw new IllegalArgumentException("Wage must be >= 0");
        this.wage = wage;
    }

    public void setHoursWorked(double hoursWorked) {
        if(hoursWorked < 0.0 || hoursWorked > 168.0) throw new IllegalArgumentException("Wrong hours input!");
        this.hoursWorked = hoursWorked;
    }

    public double getWage() {
        return wage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double earnings() {
        if(getHoursWorked() < 40) {
            return getWage() * getHoursWorked();
        } else {
            return 40* getWage() + (getHoursWorked() - 40) * getWage() * 1.5;
        }
    }

    @Override
    public String toString() {
        return "Hourly employee: \n" + super.toString() + "\nWage: " + getWage() + "\nHours worked: " + getHoursWorked();
    }
}