package Main;

public class Employee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private Compensation comp;

	public Employee(String firstName, String lastName, String socialSecurityNumber,
			Compensation comp) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.comp = comp;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setCompensationModel(Compensation comp) {
		this.comp = comp;
	}

	public double earnings() {
		return comp.earnings();
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s %.2f", "employee", firstName, lastName, "social security number",
				socialSecurityNumber, "earnings", earnings());
	}

}
