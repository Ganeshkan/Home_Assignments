package week3.day3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		
//		Declare a String array and add the values as {HCL, Wipro, Aspire Systems, CTS}  
		List<String> Company = new LinkedList<String>();
		Company.add("HCL");
		Company.add("Wipro");
		Company.add("Aspire Systems");
		Company.add("CTS");
		
//		Add the collection to a list 
		Collections.sort(Company); // Ascending Order
	    Collections.reverse(Company); //reverse the Order
	    
	    
	    List<String> output = new LinkedList<String>();
//		Iterate the values in the list
		for(String name:Company) {
			output.add(name);
		}
			
//		Print the required output as Wipro, HCL, CTS, Aspire Systems
		System.out.println("Output:" + output);
		
	}

}
