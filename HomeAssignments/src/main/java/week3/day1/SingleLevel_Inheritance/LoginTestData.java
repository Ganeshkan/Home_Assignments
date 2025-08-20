package week3.day1.SingleLevel_Inheritance;

public class LoginTestData extends TestData{

	void enterUsername(String name){
		System.out.println("Entered Name: "+ name);
	}
	void enterPassword(String password) {
		System.out.println("Entered password: "+ password);
	}

	public static void main(String[] args) {
		LoginTestData login = new LoginTestData();
		login.enterCredentials();
		login.enterUsername("ganesh");
		login.enterPassword("Jhad(7%4");
		login.navigateToHomePage();
	}








}
