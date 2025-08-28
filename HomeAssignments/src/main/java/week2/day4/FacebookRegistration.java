package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FacebookRegistration {
@Test
	public void facebookReg() throws InterruptedException {
		
		//Initialize chromedriver
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//load url
		driver.get("https://facebook.com/");
		
		
		//		- Click on the Create new account button. 
		
		WebElement createAC =  driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAC.click();

		//		- Enter the First name.
		driver.findElement(By.name("firstname")).sendKeys("ganesh");

		//		- Enter the Surname. 
		driver.findElement(By.name("lastname")).sendKeys("kumar");

		//		- Enter the Mobile number or email address.
		driver.findElement(By.name("reg_email__")).sendKeys("983984758");
		//		- Enter the New password. 
		driver.findElement(By.id("password_step_input")).sendKeys("Ganes#092");
		//		- Handle all three dropdowns in Date of birth 
		WebElement dayddl= driver.findElement(By.name("birthday_day"));
		dayddl.click();
		Select day = new Select(dayddl);
		day.selectByValue("30");

		WebElement monthddl = driver.findElement(By.name("birthday_month"));
		monthddl.click();
		Select month = new Select(monthddl);
		month.selectByVisibleText("Jul");

		WebElement YearDDL= driver.findElement(By.name("birthday_year"));
		YearDDL.click();
		Select year = new Select(YearDDL);
		year.selectByValue("1999");


		//		- Select the radio button in Gender.
		driver.findElement(By.name("//label[text()='Male']")).click();


	}

}
