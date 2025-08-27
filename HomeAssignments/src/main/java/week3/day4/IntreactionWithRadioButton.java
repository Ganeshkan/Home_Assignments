package week3.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IntreactionWithRadioButton {

	public static void main(String[] args) throws InterruptedException {

		//Initialize the ChromeBrowser
	
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);

		//launch url
		driver.get("https://www.leafground.com/radio.xhtml");
		//implement implicit wait - globally
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		//				- Select 'Your most favourite browser' from the radio buttons 
		driver.findElement(By.xpath("(//label[text()='Chrome'])[1]")).click();
		WebElement FavoriteBrowser = driver.findElement(By.id("j_idt87:console1:0"));
		if(FavoriteBrowser.isSelected()) {
			System.out.println("Favorite Browser Radio button: Enabled");
		}
		//				- Click on a radio button, then click on the same radio button again to verify that it becomes ‘unselected’.
		WebElement UnSelectablebutton = driver.findElement(By.xpath("//label[text()='Chennai']"));
		UnSelectablebutton.click();
		//Click Again to unselect
		UnSelectablebutton.click();
		WebElement UnSelectable = driver.findElement(By.id("j_idt87:city2:0"));
		if(UnSelectable.isSelected()) {
			System.out.println("UnSelectable Radio button: Enabled");
		}else {
			System.out.println("UnSelectable button: disabled");
		}
		//Identify the radio button that is initially selected by default. 
		WebElement radioButton = driver.findElement(By.xpath("//input[@id='j_idt87:console2:2']"));
		if(radioButton.isSelected()) {
			System.out.println("Radio button is initially selected by default");
		}else {
			System.err.println("Radio button Not Selected");
		}

		//	Check and select the age group (21-40 Years) if not already selected.
		WebElement AgeradioButton = driver.findElement(By.xpath("//input[@id='j_idt87:age:1']"));
		if(AgeradioButton.isSelected()) {
			System.out.println("Radio button is already selected");
		}else {
			System.err.println("Radio button Not Selected");
			AgeradioButton.click();
		}
		driver.close();
		
	}

}
