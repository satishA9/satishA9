package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaytmAuto {

	public static void main(String[] args)
	{
	System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://paytm.com");
	//driver.findElement(By.xpath("//div[text()='Log In/Sign Up']")).click();
	driver.findElement(By.xpath("(//i[@class='iconMenu cursor'])[1]")).click();
	}

}
