package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTableInteractions {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver= new ChromeDriver();
		// Launch the erail URL. 
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Enter "MAS" as the "From" station. 
		String FromStation = "MAS";   
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys(FromStation);
		Actions action = new Actions(driver);
		WebElement fromS = driver.findElement(By.xpath("//strong[contains(text(),'" +FromStation+"')]//parent::div"));
		action.moveToElement(fromS).click().perform();
		// Enter "MDU" as the "To" station.
		String ToStation = "MDU";
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys(ToStation);
		WebElement toS = driver.findElement(By.xpath("//strong[contains(text(),'" +ToStation+"')]//parent::div"));
		action.moveToElement(toS).click().perform();
		//Uncheck the "Sort on Date" checkbox. 
		driver.findElement(By.id("tdDateOnly")).click();

		//Retrieve the train names from the web table.
		List<WebElement> train = driver.findElements(By.xpath("//td[@Style=';']//a"));
		List<String> TName = new ArrayList<String>();
		//Verify if there are any duplicate train names in the web table.
		Set<String> uniqueTrains = new HashSet<String>();
		Set<String> duplicateTrains = new HashSet<String>();

		for(WebElement TrainName: train) {
			TName.add(TrainName.getText());
			String name = TrainName.getText().trim();
			if(!uniqueTrains.add(name)) {
				duplicateTrains.add(name);
			}
		}
		System.out.println("Available Trains are : " + TName);
		
		if(duplicateTrains.isEmpty()){
			System.out.println("No duplicate Train Name Fount");
		}else {
			System.err.println("Duplicate Trains Fount : " + duplicateTrains);
		}

		driver.close();

	}

}
