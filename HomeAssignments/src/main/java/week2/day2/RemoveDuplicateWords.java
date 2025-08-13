package week2.day2;

public class RemoveDuplicateWords {

	public static void main(String[] args) {

	        String text = "We learn Java basics as part of java sessions in java week1";
	        int count;

	        // Split into words
	        String[] words = text.split(" ");

	        // Compare each word with every other word
	        for (int i = 0; i < words.length; i++) {
	            count = 1;

	            // Inner loop starts from the next element
	            for (int j = i + 1; j < words.length; j++) {
	                if (words[i].equalsIgnoreCase(words[j]) && !words[i].equals("")) {
	                    count++;
	                    words[j] = ""; // replace duplicate
	                }
	            }
	        }

	        // Print result without extra spaces
	        for (String word : words) {
	            if (!word.equals("")) {
	                System.out.print(word + " ");
	            }
	        }
	    }

}
