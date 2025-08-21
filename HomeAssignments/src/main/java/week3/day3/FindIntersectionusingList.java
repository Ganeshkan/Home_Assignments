package week3.day3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindIntersectionusingList {

	public static void main(String[] args) {

		List<Integer> arr1 = new LinkedList<>(Arrays.asList(3, 2, 11, 4, 6, 7));
		List<Integer> arr2 = new LinkedList<>(Arrays.asList(1, 2, 8, 4, 9, 7));

		for(Integer num1:arr1) {          //-------> iterate the arr1
			for(Integer num2:arr2) {       //------->iterate the arr1
				if(num1.equals(num2)) {      //-----> compare the Values 
					System.out.print(num1 + " ");
				}
			}
		}	
	}
}
