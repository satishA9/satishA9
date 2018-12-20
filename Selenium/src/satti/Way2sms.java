package satti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Way2sms 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.way2sms.com/send-sms");
		driver.findElement(By.name("mobileNo")).sendKeys("7207575128");
		driver.findElement(By.name("password")).sendKeys("7207575128");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[text()='Login'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.name("toMobile")).sendKeys("7207575128");
		driver.findElement(By.name("message")).sendKeys("hi hello how are you");
		
	}

}
