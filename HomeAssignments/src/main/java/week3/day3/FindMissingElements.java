package week3.day3;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindMissingElements {

	public static void main(String[] args) {

		List<Integer> numbers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 10, 6, 8));
		Collections.sort(numbers);

		for(int i =0; i<numbers.size()-1; i++) {
			int current = numbers.get(i);
			int next = numbers.get(i+1);

			if(current+1!=next) {
				for(int j= current+1; j<next; j++) {
					System.out.println(j);
				}
			}
		}

	}
}
