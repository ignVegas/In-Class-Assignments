package Main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args)
	{
		 ArrayList<Employee> employees = new ArrayList<>();
		 SalaryEmployee salariedEmployee = new SalaryEmployee("Vegas","M","234-25-2582", 600.00);
	     HourlyEmployee hourlyEmployee = new HourlyEmployee("Gabe","O","666-66-666",20,44);
	     CommissionEmployee commisionEmployee = new CommissionEmployee("Jas","B","225-23-2625",12524,.1);
	     BasePlusCommission basePlusCommisionEmployee = new BasePlusCommission("Tyler","L","696-96-969",2000,.2,488);
	        

	        employees.add(hourlyEmployee);
	        employees.add(salariedEmployee);
	        employees.add(commisionEmployee);
	        employees.add(basePlusCommisionEmployee);
	        
	        for (Employee e: employees) {
	        	System.out.println("-------------");
	            System.out.println(e);
	            System.out.println("Money: " + e.earnings());
	            
	        }
	 }
}
