package Main;

public class CommissionEmployee extends Employee {
    private double sales;
    private double commisionRate;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,double sales,double commisionRate) {
        super(firstName, lastName, socialSecurityNumber);
        if(sales < 0.0) throw new IllegalArgumentException("Gross sales must be >= 0");
        if(commisionRate <= 0.0 || commisionRate >= 1.0) throw new IllegalArgumentException("Commision rate error!");
        this.commisionRate = commisionRate;
        this.sales = sales;
    }

    public void setSales(double sales) {
        if(sales < 0.0) throw new IllegalArgumentException("Gross sales must be >= 0");
        this.sales = sales;
    }

    public void setCommisionRate(double commisionRate) {
        if(commisionRate <= 0.0 || commisionRate >= 1.0) throw new IllegalArgumentException("Commision rate error!");
        this.commisionRate = commisionRate;
    }

    public double getSales() {
        return sales;
    }

    public double getCommisionRate() {
        return commisionRate;
    }

    @Override
    public double earnings() {
        return getCommisionRate() * getSales();
    }

    @Override
    public String toString() {
        return "Commision employee: \n" + super.toString() + "\nSales: " + getSales() + "\nCommision rate: " + getCommisionRate();
    }
}