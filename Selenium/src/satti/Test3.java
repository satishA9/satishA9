package satti;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		WebDriver c = new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://www.google.com/");
		Thread.sleep(6000);
		if(c.manage().getCookies().size()!=0)
       {
	     System.out.println("cookies were loaded");
       }
       else
    
       {
    	   System.out.println("cookies were not  loaded");
       }
	c.close();
	}

}
