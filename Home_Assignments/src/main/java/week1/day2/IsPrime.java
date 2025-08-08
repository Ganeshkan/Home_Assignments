package week1.day2;

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number: ");
		int num = sc.nextInt();
		
		int count=0;

		for(int i = 1; i<=num; i++) {
			if (num%i==0) {
				count++;
			}
		}
		if (count==2) {
			System.out.println(num + " is a prime Number");
		}else {
			System.out.println(num + " is not a prime Number");
		}
		sc.close();
	}

}
