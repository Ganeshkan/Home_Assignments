package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class interactionWithAction {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		//Load the URL (https://www.amazon.in/)
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String landingpage = driver.getTitle();
		System.out.println(landingpage);
		//Handling if Continue Shopping button displays
		if(landingpage.equals("Amazon.in")) {
			driver.findElement(By.className("a-button-text")).click();
		}else {
			System.out.println("Amazon launched without Interrption");
		}
		//Search for "oneplus 9 pro".
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro mobile phone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		//Get the Price of the First product
		System.out.println("Price: " + driver.findElement(By.className("a-price-whole")).getText());
		//Customer Ratings
		Actions action = new Actions(driver);
		WebElement ratings = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
		System.out.println("No of Customers Rated: " + ratings.getText());

		//Click the First text Link in Image using Action Class
		WebElement img = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
		action.click(img).build().perform();
		//Click Add to Cart
		WebElement AddtoCard = driver.findElement(By.xpath("(//span[@id='submit.add-to-cart-announce'])[2]"));
		action.moveToElement(AddtoCard).click().build().perform();
		//click the card subtotal and verify if it correct
		String subtotal = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Cart subtotal:  "+ subtotal );
		//close the browser
		driver.close();
	}

}
