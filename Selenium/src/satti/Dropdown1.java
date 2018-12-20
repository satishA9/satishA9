package satti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown1 
{

	public static void main(String[] args) throws Exception 
	{
		// set the geckodriver.exe property
		    System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
	        ChromeDriver driver = new ChromeDriver();
            driver.get("http://www.spicejet.com/");
            driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // dropdown box for Xpath
            driver.findElement(By.xpath("(//a[@value='PAT'])[1]")).click(); // In that dropdown value Attribute  we need to select "Patna"
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//a[@value='HYD'])[1]")).click(); // selenium is checking that code from left to right  In that Dropdown index1 is for Group1 and Index2 for "Hyderabad"
               
	}
	

}
