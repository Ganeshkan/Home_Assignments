package week2.day2;

public class ReverseOddWordsInString {

	public static void main(String[] args) {
		String test = "I am a software tester";
		String[] words = test.split(" ");// Split the sentence into words
		
		for(int i = 0; i<words.length; i++) {
			if(i%2==0) {// Even index
				System.out.print(words[i]+ " ");
			}else {
				// Odd index → reverse and print
				char[] reverseString = words[i].toCharArray();
				for(int j = reverseString.length-1; j>=0; j--) {
					System.out.print(reverseString[j]);
				}
				System.out.print(" ");// space after reversed word
			}
		}
	}
}
