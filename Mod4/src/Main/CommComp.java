package Main;

public class CommComp implements Compensation {
		private double grossSales;
		private double commissionRate;

		public CommComp(double grossSales, double commissionRate) {
			this.grossSales = grossSales;
			this.commissionRate = commissionRate;
		}

		@Override
		public double earnings() {
			return grossSales * commissionRate;
		}
}
