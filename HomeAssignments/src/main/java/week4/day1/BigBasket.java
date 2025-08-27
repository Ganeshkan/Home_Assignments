package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasket {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


		//		1. Navigate to https://www.bigbasket.com/.
		driver.get("https://www.bigbasket.com/");
		String landingpage = driver.getTitle();
		System.out.println(landingpage);
		//			2. Click on "Shop by Category".
		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:Ramkj6:']")).click();
		//			3. Mouse over "Foodgrains, Oil & Masala".
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		WebElement category = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		action.moveToElement(category).build().perform();

		//			4. Mouse over "Rice & Rice Products".
		Thread.sleep(1000);
		WebElement subcategory = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
		action.moveToElement(subcategory).build().perform();

		//			5. Click on "Boiled & Steam Rice".
		Thread.sleep(1000);
		WebElement product = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']"))));
		action.moveToElement(product).click().build().perform();
		//			6. Filter the results by selecting the brand "bb Royal".
		Thread.sleep(3000);
		WebElement brand = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='i-bbRoyal']"))));
		action.moveToElement(brand).click().build().perform();
		//			7. Click on "Tamil Ponni Boiled Rice".
		Thread.sleep(3000);
		WebElement Variant = driver.findElement(By.xpath("//input[@id='i-PonniBoiledRice']"));
		action.moveToElement(Variant).click().perform();

		//			8. Select the 5 Kg bag.
		Thread.sleep(3000);
		WebElement packSize = driver.findElement(By.xpath("//label[contains(text(),'5 kg')]"));
		action.moveToElement(packSize).click().perform();


		//			9. Check and note the price of the rice.
		Thread.sleep(3000);
		WebElement pricetag = driver.findElement(By.xpath("(//div[@class='py-1.5 xl:py-1']//span//span[contains(text(),'5 kg')])[2]"));
		WebElement Brand = driver.findElement(By.xpath("(//h3[contains(text(),'Tamil Ponni Boiled Rice')])[2]"));
		System.out.println("Price : "+pricetag.getText()+ "||"+ " Brand : "+ Brand.getText());
		action.moveToElement(Brand).click().perform();
		Thread.sleep(4000);

		//10. Click "Add" to add the bag to your cart.
		Set<String> allWindows = driver.getWindowHandles();
		List<String> listWindow=new ArrayList<String>(allWindows);

		if (!listWindow.equals(listWindow.get(1))) {
			driver.switchTo().window(listWindow.get(1));
		}

		WebElement AddToCart = driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]"));
		action.moveToElement(AddToCart).click().perform();
		Thread.sleep(1000);

		//			11. Verify the success message that confirms the item was added to your cart.
		String confirmMsg = driver.findElement(By.xpath("//p[@class='mx-4 flex-1']")).getText();
		System.out.println(confirmMsg);

		//			12. Close the current window
		driver.close();

		//			13. Close the main window.
		driver.switchTo().window(listWindow.get(0));
		driver.close();
	}

}
