package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test5

{

	public static void main(String[] args) throws InterruptedException
	
{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		WebDriver ab = new ChromeDriver();
		ab.manage().window().maximize();
		ab.get("https://jqueryui.com/droppable/");
		Thread.sleep(5000);
		ab.switchTo().frame(0); // 
		WebElement e = ab.findElement(By.id("draggable"));
		Thread.sleep(5000);
		WebElement e1 = ab.findElement(By.id("droppable"));
		Actions a = new Actions(ab);
		a.dragAndDrop(e,e1).build().perform();
		ab.switchTo().defaultContent();

		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
