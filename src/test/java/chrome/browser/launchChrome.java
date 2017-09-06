package chrome.browser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.csvreader.CsvReader;

public class launchChrome {
	
	static String driverPath = (new java.io.File("").getAbsolutePath());
	public ChromeDriver driver;
	public String test ="";
	
	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException, FileNotFoundException {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+ "/chromedriver");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setVersion("55.0.2883.75");
		capabilities.setCapability("chrome.switches",
			    Arrays.asList("--verbose"));
		
		ChromeOptions options = new ChromeOptions();
        
		options.addArguments("--test-type");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("no-sandbox");
		options.addArguments("--disable-extensions");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setPlatform(org.openqa.selenium.Platform.YOSEMITE);
		//driver = new ChromeDriver(options);
		//WebDriver driver = new ChromeDriver();
		//driver = new RemoteWebDriver(new URL("http://localhost:9515/wd/hub"), capabilities);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		 driver.navigate().to("http://yahoo.com");
		 
		//Get scanner instance
		 try {
				
				CsvReader products = new CsvReader(driverPath + "/link_list.csv");
			
				products.readHeaders();

				while (products.readRecord())
				{
					String productID = products.get("url");
				
					
					// perform program logic here
					System.out.println(productID + ":");
					
					driver.navigate().to(productID);
		            
		            String strPageTitle = driver.getTitle();
		    		System.out.println("About to take a screenshot for: - "+strPageTitle);
		    		
		    		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save(driverPath + "/RLRL-897");
		    		Thread.sleep(500); 
				}
		
				products.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	         
	        //Get all tokens and store them in some data structure
	        //I am just printing them
	       
	
	//This well check the page title
	@Test(priority=1)
	public void getURL() throws InterruptedException, IOException
	{
		
	
		
		
		
		
		
	}
	// This will scroll to element Back to the top and perform the a click on Back to the top
	@Test(priority=2)
	public void backTop() throws InterruptedException, IOException
	{

		
		//WebElement element = driver.findElement(By.linkText("Back to Top"));
	//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//	Thread.sleep(500); 
		
		//driver.findElement(By.linkText("Back to Top")).click();
		//Thread.sleep(500); 

	}
	

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing chrome browser");
			driver.quit();
		}
	}
	
	
}