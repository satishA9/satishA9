package satti;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Javascript4
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
		ChromeDriver ab=new ChromeDriver();
		ab.manage().window().maximize();    
		ab.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(4000);
		//Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js=(JavascriptExecutor)ab;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);"); // Top to Bottom
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0);"); // scroll bottom to Top
		 js.executeScript("window.scrollBy(0,600)"); // scrolled down to 600 pixels
		
		
	}

}
