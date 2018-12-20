
package satti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test10
{

	public static void main(String[] args) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.spicejet.com/");
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//*[text()=' Leh (IXL)']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[text()=' Guwahati (GAU)'])[2]")).click();
		driver.findElement(By.xpath("(//*[@class='ui-state-default'])[2]")).click();
		
		

	}

}
