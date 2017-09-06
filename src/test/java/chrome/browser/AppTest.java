package chrome.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AppTest
{
	
	
    public static void main(String[] args) throws Throwable
    {
    	// TODO Auto-generated method stub
    	
    	
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
    	 ChromeDriver driver = new ChromeDriver();
    	driver.get("http://ncoweb:nurun123!@qa.nco.nurunmtl.com/parallax.html");
}
}