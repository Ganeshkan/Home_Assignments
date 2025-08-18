package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegistration {

	public static void main(String[] args) throws InterruptedException {
		//Initialize chromedriver
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();

		//load url
		driver.get("https://en-gb.facebook.com/");
		
		Thread.sleep(1000);

		//		- Click on the Create new account button. 
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();

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
		day.selectByVisibleText("Jul");

		WebElement YearDDL= driver.findElement(By.name("birthday_year"));
		YearDDL.click();
		Select year = new Select(YearDDL);
		year.selectByValue("1999");


		//		- Select the radio button in Gender.
		driver.findElement(By.name("//label[text()='Male']")).click();


	}

}
