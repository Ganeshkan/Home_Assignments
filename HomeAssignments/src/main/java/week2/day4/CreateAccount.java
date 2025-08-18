package week2.day4;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateAccount {
ChromeDriver driver;



	public static void main(String[] args) {
		CreateAccount ca= new CreateAccount();
		ca.launchBrowser();
		ca.actions();
		ca.closeBrowser();
		
	}
	
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		driver = new ChromeDriver(options); //Initialize the Webdriver(ChromeDriver)
		driver.get("http://leaftaps.com/opentaps/");// load  the Url
		driver.manage().window().maximize();// Maximize the browser window.
		driver.getTitle();
	}
	
	public void actions() {
		//Enter a username and password.
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");//Enter a username and password.
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();//Click the "Login" button.
		driver.findElement(By.partialLinkText("CRM/SFA")).click();//Click on the "CRM/SFA" link.
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click(); //Click on the "Accounts" tab. 
		 driver.findElement(By.xpath("//a[contains(text(),'Create Account')]")).click();  //Click on the "Create Account" button.
		driver.findElement(By.id("accountName")).sendKeys("HUAI123"); //Enter an account name. 
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");   //Enter a description as "Selenium Automation Tester." 
		//Select "ComputerSoftware" as the industry. 
        WebElement industryDropdown = driver.findElement(By.name("industryEnumId"));
        Select industry = new Select(industryDropdown);
        industry.selectByVisibleText("Computer Software");
		
		
		//Select "S-Corporation" as ownership using SelectByVisibleText.
        WebElement ownershipDropdown = driver.findElement(By.name("ownershipEnumId"));
        Select ownership = new Select(ownershipDropdown);
        ownership.selectByVisibleText("S-Corporation");
		//Select "Employee" as the source using SelectByValue. 
        WebElement SourceDropdown = driver.findElement(By.id("dataSourceId"));
        Select source = new Select(SourceDropdown);
        source.selectByIndex(4);
        
		//Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex. 
        WebElement marketingcampaignDropdown = driver.findElement(By.id("marketingCampaignId"));
        Select  marketingcampaign= new Select(marketingcampaignDropdown);
        marketingcampaign.selectByIndex(6);
		//Select "Texas" as the state/province using SelectByValue.
        WebElement Statedropdown = driver.findElement(By.id("generalStateProvinceGeoId"));
        Select  state= new Select(Statedropdown);
        state.selectByIndex(6);
       
		//Click the "Create Account" button. 
        driver.findElement(By.className("smallSubmit")).click();
		//Verify that the account name is displayed correctly. 
        String accountName = driver.findElement(By.xpath("(//table[@class='fourColumnForm']//span)[2]")).getText();
        System.out.println("Account Name: " + accountName);	
	}
	
	public void closeBrowser() {
		//Close the browser window.
        driver.close();
	}
	
}