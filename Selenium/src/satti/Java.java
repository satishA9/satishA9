package satti;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java {
 
	public static void main(String[] args) throws Exception
	{
		
		
	System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://www.redbus.in/");
		 driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/span")).click();
		 Thread.sleep(5000);
		 List<WebElement> li=driver.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
		 int size1=li.size();
		 for(int i=1;i<size1;i++)
		 {
		 String date=li.get(i).getText();
		 System.out.println(date);
		 if(date.equals("21"))
		 {
		 li.get(i).click();
		 } 
		 }
		 
		 }
		
		
		
		
		
		
		
		
		
		
	}

	


