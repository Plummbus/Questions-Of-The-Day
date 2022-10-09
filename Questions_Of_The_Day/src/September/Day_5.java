package September;

/**
 * 
 * @author Franz Jacob hernandez (@herfrn)
 * @since 09-28-2022
 * 
 * "Vehicle Class" - Day 5 of Questions of the Day for the discord/slack ATA study groups. Since the ATA study material released this morning, I've changed the content of this series
 * to follow along with the ATA study material that people are using. Today's question(s) goes over the topics in 4.1 and 4.2 of the canvas: reading UML class diagrams,
 * creating a class from that diagram, and assigning values to variables. The diagram for this class will be posted in the respective channels. People coding for the first time
 * will ahve to look up some extra concepts if they have only gone through 4.1 and 4.2: (1) accessing indices of an array, (2) printing to the console, (3) if-else statements
 * if they want to do error-checking for the printBrandAtIndex() method (optional).
 *
 */
public class Day_5 {

	public static void main(String[] args) {
		String[] brandsArray = new String[] {
				"Rolls-Royce", "Bentley", "Mercedes-Benz", "Tesla", "Porsche"
		};
		Vehicle fancyCar = new Vehicle(20000, 2020, "Luxury", true);
		fancyCar.printBrandAtIndex(0);	//will show null
		fancyCar.setBrands(brandsArray);
		
		int negativeInteger = -1;
		int greaterThanLengthInteger = 10;
		int validInteger = 0;
		
		fancyCar.printBrandAtIndex(negativeInteger);
		fancyCar.printBrandAtIndex(greaterThanLengthInteger);
		fancyCar.printBrandAtIndex(validInteger);

	}
	

	public static class Vehicle {
		
		private double miles;
		private int year;
		private String type;
		private boolean isRegistered;
		private String[] brands;
		
		public Vehicle(double miles, int year, String type, boolean isRegistered) {
			this.miles = miles;
			this.year = year;
			this.type = type;
			this.isRegistered = isRegistered;
			this.brands = new String[1]; 
		}

		public double getMiles() {
			return miles;
		}

		public int getYear() {
			return year;
		}

		public String getType() {
			return type;
		}

		public boolean getIsRegistered() {
			return isRegistered;
		}
		
		public String[] getBrands() {
			return this.brands;
		}
		
		public void setBrands(String[] array) {
			this.brands = array;
		}
		
		public void printBrandAtIndex(int i) {
			String message = "";
			if (i < 0) {
				message += "The integer entered cannot be negative.";
			} else if (i >= this.brands.length) {
				message += "The integer entered must be a valid index.";
			} else {
				message += "The brand at index " + i + ": " + this.brands[i];
			}
			System.out.println(message);
		}
		
	}

}


