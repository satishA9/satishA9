package satti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;

public class ActionsClass 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
		ChromeDriver ab=new ChromeDriver();
		ab.manage().window().maximize();
		ab.get("https://store.demoqa.com/products-page/product-category/iphones/");
	  /*  WebElement e=ab.findElement(By.linkText("Product Category")); // Dropdown for the Product Category and created DOM 
	    ab.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
		Actions a=new Actions(ab);
		a.moveToElement(e).build().perform();
		ab.findElement(By.linkText("MacBooks")).click();// x-path for Iphones 
		ab.findElement(By.xpath("(//*[@class='wpsc_buy_button'])[2]")).getText(); // xpath for 2nd Add to cart*/
		WebElement e=ab.findElement(By.xpath("//*[text()='iMacs']"));
		ab.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Actions a=new Actions(ab);
		a.moveToElement(e).build().perform();
	    ab.findElement(By.xpath("//a[text()='Magic Mouse']")).click();
		
		
		  	
		
	}

}
