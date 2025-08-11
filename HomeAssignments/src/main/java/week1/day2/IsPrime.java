package week1.day2;

public class IsPrime {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		int d = 0;
		for (int i = 2; i <= n - 1; i++) {
			if (n % i == 0) {

				System.out.println("Is Not a Prime Number");

				d = d + 1;
				break;
			}
		}
		if (d == 0)

			System.out.println("Is  a Prime Number");
	}
}
