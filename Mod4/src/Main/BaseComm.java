package Main;


public class BaseComm implements Compensation {
	private double grossSales;
	private double commissionRate;
	private double baseSalary;

	public BaseComm(double grossSales, double commissionRate, double baseSalary) {
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
		this.baseSalary = baseSalary;
	}

	@Override
	public double earnings() {
		return baseSalary + grossSales * commissionRate;
	}
}