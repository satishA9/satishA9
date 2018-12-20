package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test13
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		Select s= new Select(driver.findElement(By.name("country")));
		s.selectByVisibleText("LIBYA");   // dropdown for Libya
		driver.get("http://output.jsbin.com/osebed/2");
		Select s1=new Select(driver.findElement(By.id("fruits")));// In dropdown we need to select for Fruits
		s1.selectByVisibleText("Grape");
	    s1.selectByIndex(2);
	    
		

	}

}
