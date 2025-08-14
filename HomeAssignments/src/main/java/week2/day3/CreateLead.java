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

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");//Enter a username and password.
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();//Click the "Login" button.
		driver.findElement(By.partialLinkText("CRM/SFA")).click();//Click on the "CRM/SFA" link. 
		driver.findElement(By.partialLinkText("Leads")).click();//Click on the "Leads" tab.
		driver.findElement(By.partialLinkText("Create Lead")).click();	//Click on the "Create Lead" button. 
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ganesh");//Enter a FirstName. 
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("kumar");//Enter a LastName. 
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");//Enter a CompanyName.
		String title = driver.getTitle();//Enter a Title 
		driver.findElement(By.name("submitButton")).click();//Click the "Create Lead" button.
		System.out.println(title);//Print theTitle.
		driver.close();//Close the browser window.
	}
}



