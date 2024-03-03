package Main;

public class Hourly implements Compensation {
	private double wage;
	private double hours;

	public Hourly(double wage, double hours) {
		this.wage = wage;
		this.hours = hours;
	}

	@Override
	public double earnings() {
		if (hours <= 40) { 
			return wage * hours;
		} else {
			return 40 * wage + (hours - 40) * wage * 1.5;
		}
	} 

}
