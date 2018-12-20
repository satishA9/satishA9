package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown2 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		WebDriver ab=new ChromeDriver();
		ab.manage().window().maximize();
		ab.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		Select s=new Select(ab.findElement(By.id("select-demo"))); // "select" class is there we wrote and dropdown for xpath
		s.selectByVisibleText("Friday");  //visible for active text is "Friday"
	    s.selectByIndex(4);
		s.selectByValue("Friday");
	}

}
