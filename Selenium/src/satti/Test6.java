package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test6 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://jqueryui.com/slider/");
		Thread.sleep(5000);
		cd.switchTo().frame(0);
		WebElement e= cd.findElement(By.xpath("//*[@class='ui-slider-handle ui-corner-all ui-state-default']")); // xpath for Horizontal Slider
		Actions a = new Actions(cd);
		int x =e.getLocation().getX();
		int y =e.getLocation().getY();
		// slider from Left To Right
		a.dragAndDropBy(e,x+200,y).build().perform();
		cd.switchTo().defaultContent();
		Thread.sleep(6000);
		cd.findElement(By.linkText("Vertical slider")).click();
		WebElement e1=cd.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));    // xpath for vertical slider
		int p= e1.getLocation().getX();
		int q=e1.getLocation().getY();
		a.dragAndDropBy(e1, p, q+200).build().perform(); // slider from top to bottom
		a.dragAndDropBy(e1, p, q-400).build().perform(); // slider from bottom to top
		cd.switchTo().defaultContent();
		
		
				
		
		
		
		
		
		
		
		
	}

}
