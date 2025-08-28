package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EditLead {
@Test
	public void editLead() {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/.");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//		Enter the Username as "DemoSalesManager" and the Password as "crmsfa".
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//		Click on the Login Button.
		driver.findElement(By.className("decorativeSubmit")).click();
		//		Click on the CRM/SFA Link. 
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		//		Click on the Leads Button.
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		//		Click on Create Lead.
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		//		Enter the CompanyName Field Using Xpath.
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HP");
		//		Enter the FirstName Field Using Xpath. 
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ganesh");
		//		Enter the LastName Field Using Xpath. 
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kumar");
		//		Enter the FirstName (Local) Field Using Xpath. 
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("GANE");
		//		Enter the Department Field Using any Locator of Your Choice. 
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("SoftwareTester");

		//		Enter the Description Field Using any Locator of your choice.
		driver.findElement(By.id("createLeadForm_description")).sendKeys("SoftwareTesting");

		//		Enter your email in the E-mail address Field using the locator of your choice.
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("gk123@email.com");

		//		Select State/Province as NewYork Using Visible Text.
		WebElement StateDropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		StateDropdown.click();
		Select State = new Select(StateDropdown);
		State.selectByVisibleText("New York");

		//		Click on the Create Button.
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();

		//		Click on the edit button. - Clear the Description Field.
		WebElement editButton= driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
		wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();


		//		Fill the Important Note Field with Any text.
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("software Testing");
		//		Click on the update button.
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		//		Get the Title of the Resulting Page.
		System.out.println(driver.getTitle());
		//		Close the browser window. 
		driver.close();
	}

}
