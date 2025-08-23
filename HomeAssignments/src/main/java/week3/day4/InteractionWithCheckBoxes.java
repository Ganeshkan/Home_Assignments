package week3.day4;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InteractionWithCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		//Initialize the ChromeBrowser
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();

		//implement implicit wait - globally
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//launch url
		driver.get("https://leafground.com/checkbox.xhtml");

		//- Click on the "Basic Checkbox."
		driver.findElement(By.xpath("//span[text()='Basic']//parent::div")).click();

		//		- Click on the "Notification Checkbox." 
		WebElement Notification = driver.findElement(By.xpath("//span[text()='Ajax']//parent::div"));
		Notification.click();

		//		- Verify that the expected message is displayed.
		System.out.println("Message: "+ driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText());

		//		- Click on your favorite language (assuming it's related to checkboxes). 
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		driver.findElement(By.xpath("//label[text()='Javascript']")).click();


		//		- Click on the "Tri-State Checkbox." 
		driver.findElement(By.xpath("//span[@class='ui-chkbox-icon ui-c ']//parent::div")).click();

		//		- Verify which tri-state option has been chosen. 
		System.out.println(driver.findElement(By.xpath("//*[@id=\"j_idt87:id_container\"]/div/div/div[2]/span")).getText());

		//		- Click on the "Toggle Switch." 
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
		Thread.sleep(500);

		//		- Verify that the expected message is displayed. 
		driver.findElement(By.xpath("//*[@id=\"j_idt87:msg_container\"]/div/div/div[2]/span")).getText();

		//		- Verify if the Checkbox is disabled. 
		WebElement checkBox=driver.findElement(By.xpath("//input[@name='j_idt87:j_idt102_input']"));
		if(!checkBox.isEnabled()) {
			System.out.println("check box is disabled");
		}else {
			System.out.println("check box is Enabled");
		}

		//		- Select multiple options on the page (details may be needed). 
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		driver.findElement(By.xpath("(//label[text()='Paris'])[2]")).click();
		driver.findElement(By.xpath("(//label[text()='London'])[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Barcelona'])[2]")).click();
		driver.findElement(By.xpath("//a[@aria-label='Close']")).click();

		//		- Perform any additional actions or verifications required.
		WebElement notification = driver.findElement(By.xpath("//input[@value='java']"));
		if(notification.isSelected()) {
			System.out.println("notification checkbox Checked");
		}
			//		- Close the web browser when done. 
			driver.close();
	}

}
