package satti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScript6 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		ChromeDriver ab=new ChromeDriver();
		ab.manage().window().maximize();
		ab.get("http://www.google.co.in");
		ab.findElement(By.name("q")).sendKeys(" kalam");
		Thread.sleep(5000);
		Actions a=new Actions(ab);
		int c=0;
		while(2>1)
		{
			String x=ab.findElement(By.name("q")).getAttribute("value");
			if(x.equals("kalam quotes"))
			{
				a.sendKeys(Keys.ENTER).build().perform();
				break;
			}
		
			else
			{
			a.sendKeys(Keys.DOWN).build().perform();
			c=c+1;
			if(c>0)
			{
				a.sendKeys(Keys.ESCAPE).build().perform();
				break;
			}
			   Thread.sleep(5000);
			
		}	
			
			
		}
				
		
	

	}

}
