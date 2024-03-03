package Main;


public class Salary implements Compensation {
	private double weeklySalary;

	public Salary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	@Override
	public double earnings() {
		return weeklySalary;
	}
}