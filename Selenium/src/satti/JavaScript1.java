package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class JavaScript1 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		ChromeDriver cd=new ChromeDriver();
		cd.get("http://www.google.co.in");
		WebElement e=cd.findElement(By.name("q"));
		JavascriptExecutor js=(JavascriptExecutor)cd;
		js.executeScript("arguments[0].value='abdul kalam';",e);// arg[0] is a fixed object*/


	}

}
