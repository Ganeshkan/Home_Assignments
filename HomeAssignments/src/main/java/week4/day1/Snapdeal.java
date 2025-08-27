package week4.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//1. Launch (https://www.snapdeal.com/)
		driver.get("https://www.snapdeal.com/");
		String landingpage = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		System.out.println(landingpage);
		Actions action = new Actions(driver);
		
		//2. Go to "Men's Fashion".
		WebElement mensfashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		action.moveToElement(mensfashion).perform();

		//3. Go to "Sports Shoes".
		WebElement sportsshoes = driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));
		action.moveToElement(sportsshoes).click().perform();

		//4. Get the count of sports shoes.
		WebElement countOfShoes = driver.findElement(By.xpath("//div[@class='sub-cat-count ']"));
		System.out.println("count of sports shoes : " + countOfShoes.getText());

		//5. Click on "Training Shoes".
		WebElement TrainingShoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		action.moveToElement(TrainingShoes).click().perform();

		//6. Sort the products by "Low to High".
		Thread.sleep(1000);
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-selected']"));
		sort.click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();

		//7. Check if the displayed items are sorted correctly.
		System.out.println("Sort By : " + sort.getText());

		//8. Select any price range ex:(500-700).
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("700");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1000");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();

		//9. Filter by any colour.
		Thread.sleep(2000);
		WebElement selectcolor = driver.findElement(By.xpath("//a[contains(text(),' White & Blue')]//parent::label"));
		action.moveToElement(selectcolor).click().perform();

		//10. Verify all the applied filters.
		Thread.sleep(2000);
		WebElement price = driver.findElement(By.xpath("//a[@data-key='Price|Price']"));
		WebElement color = driver.findElement(By.xpath("//a[@data-key='Color_s|Color']"));
		System.out.println("Price : "+ price.getText() + " Color : " + color.getText());

		//11. Mouse hover on the first resulting "Training Shoes".
		Thread.sleep(2000);
		WebElement SelectProduct = driver.findElement(By.xpath("//p[@class='product-title']"));
		action.moveToElement(SelectProduct).perform();

		//12. Click the "Quick View" button.
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		Thread.sleep(5000);

		//13. Print the cost and the discount percentage.
		System.out.println("Price :" + driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());
		System.out.println("Price :" + driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());

		//14. Close the current window.
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();

		//15. Close the main window.
		driver.close();
	}

}
