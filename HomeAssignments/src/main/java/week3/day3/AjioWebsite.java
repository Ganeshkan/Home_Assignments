package week3.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AjioWebsite {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("Guest");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/-");
		
//		In the search box, type as "bags" and press enter 
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("bags");
		driver.findElement(By.xpath("//a//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']")).click();
		
//		- To the left of the screen under "Gender" click on "Men"
		driver.findElement(By.xpath("//label[text()='Men']")).click();
		
//		- Print the count of the items found. 
		List<WebElement> products = driver.findElements(By.className("product-brand"));
		System.out.println(products.size());
		List<String> ProductNames=new ArrayList<String>();
//		- Get the list of brand of the products displayed in the page and print the list.
		List<WebElement> Brand =driver.findElements(By.xpath("//label[@class='vertical-filters-label common-customCheckbox']"));
		List<String> BrandNames=new ArrayList<String>();
		
		for(WebElement brand:Brand) {
			String ListOfBrand = brand.getText();	
			BrandNames.add(ListOfBrand);
		}
		System.out.println("ProductName:" + BrandNames);
		
//		- Get the list of names of the bags and print it 
		List<WebElement> Nameofproducts = driver.findElements(By.className("product-brand"));
		for(WebElement product:Nameofproducts) {
			String NameOfProducts = product.getText();
			ProductNames.add(NameOfProducts);
		}
		
		System.out.println("ProductName:" + ProductNames);
	}

}
