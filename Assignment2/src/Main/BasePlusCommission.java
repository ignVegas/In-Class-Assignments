package Main;

public class BasePlusCommission extends CommissionEmployee {
    private double baseSalary;
    public BasePlusCommission(String firstName, String lastName, String socialSecurityNumber,double sales,double commisionRate,double baseSalary) 
    {
        super(firstName, lastName, socialSecurityNumber,sales,commisionRate);
        this.baseSalary = baseSalary;
     }

     public void setBaseSalary(double baseSalary)
     {
        this.baseSalary = baseSalary;
     }

     public double getBaseSalary() 
     {
        return baseSalary;
     }

     @Override
    public double earnings()
     {
        return baseSalary + super.earnings();
     }

     @Override
    public String toString()
     {
        return super.toString() + "Base salary: " + getBaseSalary();
     }

}
