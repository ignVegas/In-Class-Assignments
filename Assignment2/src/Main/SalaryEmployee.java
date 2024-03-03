package Main;

public class SalaryEmployee extends Employee
{
	private final double weeklySalary;
    SalaryEmployee(String firstName,String lastName,String socialSecNumber,double weeklySalary)
    {
        super(firstName,lastName,socialSecNumber); // called later for the string super helpful!
        
        if(weeklySalary < 0.0)
        {
        	throw new IllegalArgumentException("Weekly salary must be >= 0");
        }
        this.weeklySalary  = weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary)
    {
        if(weeklySalary < 0.0) throw new IllegalArgumentException("Weekly salary must be >= 0");
    }

    public double getWeeklySalary()
    {
        return weeklySalary;
    }

    @Override
    public double earnings() 
    {
        return getWeeklySalary();
    }

    @Override
    public String toString() 
    {
        return "Salaried employee: \n" + super.toString() + "\nWeekly salary: " + getWeeklySalary();
    }

}
