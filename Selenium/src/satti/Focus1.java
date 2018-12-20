package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Focus1 {

	public static void main(String[] args) 
	{
	
	
		System.setProperty("webdriver.gecko.driver","F:\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.snapdeal.com");
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		//driver.switchTo().alert().accept();
	
	}


}
