package week1.day2;

public class FibonaciSeries {
	
	public static void main(String[] args) {
	
		int a=0;
		int b=1;
		System.out.println(a);
		System.out.println(b);
		for(int i=2; i<8; i++)
			
		{
			int c=a+b;
			a=b;
			b=c;
			System.out.println(c);
		}
	}
}
