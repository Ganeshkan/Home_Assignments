package week2.day2;

public class ChangeOddIndexToUppercase {

	public static void main(String[] args) {
		String test = "changeme";
		char[] chararray = test.toCharArray();
		for(int index=0; index<=test.length()-1; index++) {
			if(index%2!=0) {
				chararray[index] = Character.toUpperCase(chararray[index]);
				System.out.print(chararray[index]);
			}else {
				System.out.print(chararray[index]);
			}
		}
	}

}
