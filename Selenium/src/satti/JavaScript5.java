package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScript5 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
		ChromeDriver ab=new ChromeDriver();
		ab.manage().window().maximize();
		ab.get("http://www.google.co.in");
		ab.findElement(By.name("q")).sendKeys("kalam quotes");
		Thread.sleep(10000);
		Actions a=new Actions(ab);
		for(int i=1;i<=5;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(3000);
		}
		
		   a.sendKeys(Keys.ENTER).build().perform();
	}

}
