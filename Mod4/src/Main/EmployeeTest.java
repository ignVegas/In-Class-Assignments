package Main;

	public class EmployeeTest {
		public static void main(String[] args) {
			Employee employee1 = new Employee("Sue", "Jones", "222-22-2222", new Salary(300));
			Employee employee3 = new Employee("Karen", "Price", "222-22-2222", new CommComp(10000, .06));

			System.out.printf("%s%n%n", employee1);
			System.out.printf("%s%n%n", employee3);

			employee3.setCompensationModel(new CommComp(10000, .06));

			System.out.printf("%s%n%n", employee3);
		}

}
