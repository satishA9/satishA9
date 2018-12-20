package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript2 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		ChromeDriver ab=new ChromeDriver();
		ab.get("http://www.google.co.in");
		WebElement e=ab.findElement(By.name("q"));
		JavascriptExecutor js=(JavascriptExecutor)ab;
		js.executeScript("arguments[0].style.border='2px dotted red';",e);
		
		

	}

}
