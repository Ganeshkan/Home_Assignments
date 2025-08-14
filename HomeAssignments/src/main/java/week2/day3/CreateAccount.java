package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
//     initialize the browser		
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options); //Initialize the Webdriver(ChromeDriver)
		driver.get("http://leaftaps.com/opentaps/control/main");// load  the Url
		driver.manage().window().maximize();// Maximize the browser window.
		driver.getTitle();
		
//		Enter a username and password. 
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa"); 
		
//		Click the "Login" button. 
		driver.findElement(By.className("decorativeSubmit")).click();
		
//		Click on the "CRM/SFA" link. 
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		Thread.sleep(1000);
//		Click on the "Accounts" tab. 
		driver.findElement(By.partialLinkText("Accounts")).click();
		
//		Click on the "Create Account" button.
		driver.findElement(By.partialLinkText("Create Account")).click();
		
//		Enter an account name. 
		driver.findElement(By.id("accountName")).sendKeys("Testleaf");
		
//		Enter a description as "Selenium Automation Tester." 
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		
//		Enter a Number Of Employees.
		driver.findElement(By.id("numberEmployees")).sendKeys("5");
		
//		Enter a Site Name as “LeafTaps” 
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		
//		Click the "Create Account" button.
		driver.findElement(By.className("smallSubmit")).click();
		
//		Print theTitle name.
		System.out.println(driver.getTitle());
		
//		 Close the browser window.
		driver.close();

	}

}
