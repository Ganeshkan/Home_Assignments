package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DeleteLead {
@Test
	public void deleteLead() throws InterruptedException {
		//launch chrome browser as guest mode
		ChromeOptions options= new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		//launch url
		driver.get("http://leaftaps.com/opentaps/.");

		// - Enter the username. - Enter the password. - Click the Login button. 
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();//Click the "Login" button.

		driver.findElement(By.partialLinkText("CRM/SFA")).click();//Click on the "CRM/SFA" link.

		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();//Click the "Leads" link.

		//Click "Find leads." 
		WebElement FindLead= driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]"));
		FindLead.click();

		//Click on the "Phone" tab.
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();

		//Enter the phone number. 
		//driver.findElement(By.name("phoneAreaCode")).sendKeys("207");
		driver.findElement(By.name("phoneNumber")).sendKeys("123");

		//Click the "Find leads" button. 
		WebElement FindLeadButton=driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]"));
		FindLeadButton.click();
		Thread.sleep(1000);
		//Capture the lead ID of the first resulting lead. 
		WebElement LeadId = driver.findElement(By.xpath("(//table//tbody//tr//td//div//a)[1]"));
		String LeadID =LeadId.getText();
		System.out.println(LeadID);



		//Click the first resulting lead. 
		driver.findElement(By.xpath("//a[contains(text(),'" + LeadID + "')]")).click();

		//Click the "Delete" button. 
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		Thread.sleep(1000);

		//Click "Find leads" again. 
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		Thread.sleep(1000);

		//Enter the captured lead ID. 
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(LeadID);
		Thread.sleep(1000);
		//Click the "Find leads" button. 
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();


		//Verify the presence of the message "No records to display" in the Lead List. 
		String vMessage= "No records to display";
		WebElement message= driver.findElement(By.xpath("//div[contains(text(), 'records')]"));
		String msg = message.getText();
		if (vMessage.equals(msg)) {
			System.out.println("lead Deleted Successfully");
		}else {
			System.out.println("lead Not Deleted Successfully");
		}

		// Close the browser. 
		driver.close();
	}



}
