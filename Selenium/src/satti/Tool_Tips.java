package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tool_Tips {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
		WebDriver ab=new ChromeDriver();
		ab.get("https://www.seleniumhq.org/");
		ab.manage().window().maximize();
		//WebElement element = ab.findElement(By.cssSelector(".header"));
		//String toolTipText = element.getAttribute("title");
		
		

	}

}