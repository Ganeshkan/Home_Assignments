package week1.day2;

public class IsPrime {
	public static void main(String[] args) {
		int num = 17; // You can change this number to test other values
        boolean isPrime = true;

        // Check if number is less than or equal to 1
        if (num <= 1) {
            isPrime = false;
        } else {
            // Iterate from 2 to num - 1
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime) {
            System.out.println(num + " is a Prime Number.");
        } else {
            System.out.println(num + " is NOT a Prime Number.");
        }
	}
}
