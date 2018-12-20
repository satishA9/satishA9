package satti;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Handles {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		WebDriver ab=new ChromeDriver();
		ab.get("https://www.flipkart.com");
		ab.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).click(); // close the 
		ab.findElement(By.xpath("//*[@class='LM6RPg']")).sendKeys("redmi note 5",Keys.ENTER);// search box and enter the text
		ab.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ab.findElement(By.xpath("(//div[@class='_3wU53n'])[3]")).click();  // click for 3rd mobile
		ab.findElement(By.xpath("(//div[@class='_3wU53n'])[4]")).click(); 
		ArrayList<String> l=new ArrayList<String>(ab.getWindowHandles());
	    ab.switchTo().window(l.get(1));
	    ab.switchTo().window(l.get(0));
	}

}
