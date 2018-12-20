package satti;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript3 {

	public static void main(String[] args) 
	{
	
		System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
		ChromeDriver ab=new ChromeDriver();
		ab.manage().window().maximize();
		ab.get("https://semantic-ui.com/modules/dropdown.html");
		ab.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		// Get  Visible items from div  based dropdown
		List<WebElement> l=ab.findElements(By.xpath("(//*[@class='ui dropdown'])[1]"));
		System.out.println(l.size());
		JavascriptExecutor js=(JavascriptExecutor)ab;
		for(int i=0;i<l.size();i++)
		{
			js.executeScript("var x= arguments[0].textContent;alert(x);",l.get(i));
			ab.switchTo().alert().accept();
		}
		
		
		
		
	}

}
