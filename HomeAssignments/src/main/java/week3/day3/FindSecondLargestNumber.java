package week3.day3;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindSecondLargestNumber {

	public static void main(String[] args) {

		List<Integer> list = new LinkedList<>(Arrays.asList(3, 2, 11, 4, 6, 7)); // decleare  array list and Stores the value in it.

		Collections.sort(list); // ascending order 

		System.out.println(list.get(1)); // print second largest number

	}

	
}
