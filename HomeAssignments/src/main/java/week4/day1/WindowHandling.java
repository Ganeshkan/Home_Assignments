package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);

		//1. Launch (http://leaftaps.com/opentaps/control/login)
		driver.get("http://leaftaps.com/opentaps/control/login");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Enter a username and password. 
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa"); 
		//Click the "Login" button. 
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click on the "CRM/SFA" link. 
		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		//Click on the Contacts button.
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		//Click on Merge Contacts.
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		//-------Click on the widget of the "From Contact"-------
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> Window = driver.getWindowHandles();
		List<String> WindowList = new ArrayList<String>(Window);
		//Click on the first resulting contact
		driver.switchTo().window(WindowList.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tbody//tr//a)[1]")).click();
		driver.switchTo().window(WindowList.get(0));

		//-------Click on the widget of the "To Contact".-------
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		//Click on the second resulting contact.
		Set<String> window = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(window);
		driver.switchTo().window(windowsList.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tbody//tr//a)[1]")).click();
		driver.switchTo().window(windowsList.get(0));

		//-Click on the Merge button.
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		//- Accept the alert.
		driver.switchTo().alert().accept();

		//- Verify the title of the page.
		System.out.println(driver.getTitle());
	}

}
