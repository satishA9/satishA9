package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class H_Windows {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://accounts.google.com/signup");
		driver.findElement(By.xpath("//a[text()='Help']")).click();// locator for Help
		Thread.sleep(5000);
		driver.findElement(By.id("search-form")).sendKeys("abc"); // locator for Name

	}

}