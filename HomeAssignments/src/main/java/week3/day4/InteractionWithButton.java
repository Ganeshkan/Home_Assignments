package week3.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InteractionWithButton {

	public static void main(String[] args) {

		//Initialize the ChromeBrowser
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);

		//implement implicit wait - globally
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//launch url
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();

		//				- Click on the button with the text ‘Click and Confirm title.’ 
		driver.findElement(By.id("j_idt88:j_idt90")).click();
		String Actualtitle = driver.getTitle();
		String ExpectedTitle = "Dashboard";
		//				- Verify that the title of the page is ‘dashboard.’ 
		if(Actualtitle.contentEquals(ExpectedTitle)) {
			System.out.println("Click and Confirm title: Pass");
		}else {
			System.err.println("Click and Confirm title: Fail");
		}

		//				- Check if the button with the text ‘Confirm if the button is disabled’ is disabled. 
		driver.navigate().back();
		Boolean ButtonStatus = driver.findElement(By.id("j_idt88:j_idt92")).isEnabled();
		if(!ButtonStatus) {
			System.out.println("Confirm if the button is disabled : Pass");
		}else {
			System.err.println("Confirm if the button is disabled: Fail");
		}

		//				- Find and print the position of the button with the text ‘Submit.’ 
		WebElement submit = driver.findElement(By.id("j_idt88:j_idt94"));
		Point position = submit.getLocation();
		int x = position.getX();
		int y = position.getY();
		System.out.println("position x : " + x + " position y : " + y );

		//				- Find and print the background color of the button with the text ‘Find the Save button color.’ 
		WebElement save = driver.findElement(By.id("j_idt88:j_idt96"));
		String backgroundColor = save.getCssValue("background-color");
		System.out.println("BackgroundColor color of Submit button :"+ backgroundColor);


		//				- Find and print the height and width of the button with the text ‘Find the height and width of this button.’
		WebElement button = driver.findElement(By.id("j_idt88:j_idt98"));
		int height = button.getSize().getHeight();
		int width = button.getSize().getWidth();
		System.out.println("Height : " + height + " Width : " + width );

		//				- Close the browser window.
		driver.close();

	}

}
