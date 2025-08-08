package week1.day2;

public class Fibonacci_series {

	public static void main(String[] args) {

		int range = 8;

		int num1 = 0, num2 = 1 ;

		System.out.print("Fibonacci series: ");
		// Printed first two Fibonacci number seperatly
		System.out.print(num1 + ", " + num2);
		// Start from 3rd term and loop until 'range' terms are printed
		for (int i = 3; i <= range; i++) {
			int num3 = num1 + num2;
			System.out.print(", " + num3);

			num1 = num2;
			num2 = num3;
		}
	}
}
