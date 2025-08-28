package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo {

	public static void main(String[] args) {

		ChromeDriver driver= new ChromeDriver();
		// Launch the URL. 
		driver.get("https://finance.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions action = new Actions(driver);
		WebElement morebtn = driver.findElement(By.xpath("//span[text()='More']"));
		action.moveToElement(morebtn).perform();

		WebElement crypto = driver.findElement(By.xpath("//a[@aria-label='Finance: Crypto']"));
		action.moveToElement(crypto).click().perform();

		List<WebElement> cryptoName = driver.findElements(By.xpath("//td[@class='leftAlignHeader companyName yf-7uw1qi']//div"));
		List<String> CryptoNames = new ArrayList<String>();
		for(WebElement name:cryptoName) {
			CryptoNames.add(name.getText());
		}
		System.out.println("Crypto Names: " + CryptoNames );
	}
}

