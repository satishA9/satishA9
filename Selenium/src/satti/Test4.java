package satti;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test4 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		WebDriver ab = new ChromeDriver();
		ab.manage().window().maximize();
		ab.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		ab.switchTo().frame("iframeResult");
		WebElement e = ab.findElement(By.name("cars"));
		Select s = new Select(e);
		Actions a = new Actions(ab);
		a.keyDown(Keys.CONTROL).build().perform();
		a.click(s.getOptions().get(3)).build().perform();
		a.click(s.getOptions().get(0)).build().perform();
		a.keyDown(Keys.CONTROL).build().perform();
		
		
		
		
		

	}

}
