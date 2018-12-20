package satti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test9 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.flipkart.com");
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).isDisplayed())
	    {
	     driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).click();
	    }
		// move mouse pointer to an Element
		WebElement e = driver.findElement(By.xpath("//*[text()='Men']"));
		Actions a = new Actions(driver);
		a.moveToElement(e).build().perform();
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Shorts'])[1]")));
	driver.findElement(By.xpath("(//*[text()='Shorts'])[1]")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='_2cLu-l'])[4]")));
	driver.findElement(By.xpath("(//*[@class='_2cLu-l'])[4]")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("[(//*[text()='30'])[1]")));
	driver.findElement(By.xpath("(//*[text()='30'])[1]")).click();
    driver.findElement(By.xpath("[//*[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
	}

}
