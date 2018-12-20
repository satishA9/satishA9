package satti;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) throws InterruptedException 
	{
	
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver ab = new ChromeDriver();
		ab.manage().window().maximize();
		ab.get("http://www.google.co.in");
		Thread.sleep(5000);
		String x = ab.getCurrentUrl();
		if(x.contains("https"))
		 
		{
			System.out.println("secured site");
			
		}
		   
		else
	
		{
			System.out.println("Not Secured ");
		
		}
		ab.close();
	

	}

}
