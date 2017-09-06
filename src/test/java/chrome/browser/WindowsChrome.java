package chrome.browser;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.csvreader.CsvReader;

public class WindowsChrome {
  static String driverPath = (new java.io.File("").getAbsolutePath());
  private WebDriver driver;

  @BeforeClass
  public void setUp() throws Exception {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", "Chrome");
    caps.setCapability("browser_version", "60.0");
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "7");
    caps.setCapability("resolution", "1024x768");

    driver = new RemoteWebDriver(
      new URL("https://zaqwsx1:zqybk75kc8SQJmSXFKvg@hub-cloud.browserstack.com/wd/hub"),
      caps
    );
  }

  @Test
  public void testSimple() throws Exception {
    driver.get("http://www.google.com");
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

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
  }

}