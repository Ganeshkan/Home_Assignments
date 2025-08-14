package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {


	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options); //Initialize the Webdriver(ChromeDriver)
		driver.get("http://leaftaps.com/opentaps/control/main");// load  the Url
		driver.manage().window().maximize();// Maximize the browser window.
		driver.getTitle();

		//Enter a username and password.
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click the "Login" button. 
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click on the "CRM/SFA" link. 
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		//Click on the "Leads" tab. 
		driver.findElement(By.partialLinkText("Leads")).click();
		//Click on the "Create Lead" button. 
		driver.findElement(By.partialLinkText("Create Lead")).click();
		//Enter a FirstName. 
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ganesh");
		//Enter a LastName. 
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("kumar");
		//Enter a CompanyName. 
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		//Enter a Title . 
		String title = driver.getTitle();
		//Click the "Create Lead" button.
		driver.findElement(By.name("submitButton")).click();
		//Print theTitle.
		System.out.println(title);
		//Close the browser window.
		driver.close();

	}
}



