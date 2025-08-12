package week2.day2;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {
		int num[] = {1,4,3,2,8,6,7};
		Arrays.sort(num); //num={1,2,3,4,6,7,8}

		for(int i=num[0]; i<num[num.length-1]; i++) {
			if(i != num[i-num[0]]) {
				System.out.println(i);
				break;
			}
		}
	}		
}
