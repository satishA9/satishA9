package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test7
{

	public static void main(String[] args) throws InterruptedException 
	{
   System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
   WebDriver ab= new ChromeDriver();
   ab.manage().window().maximize();
   ab.get("https://semantic-ui.com/modules/dropdown.html");
   Thread.sleep(5000);
   WebElement e =ab.findElement(By.xpath("//*[@class='ui dropdown'][1]"));  // x-path for File
   Actions a =new Actions(ab);
   a.click(e).build().perform();
   for(int i=0;i<=2;i++)
   {
	   a.sendKeys(Keys.DOWN).build().perform();
   }
   
   a.sendKeys(Keys.ENTER).build().perform();
   Thread.sleep(5000);
   // Automate Dropdown,which can allow character matching
  WebElement e1= ab.findElement(By.xpath("(//*[@class='ui dropdown selection'])[1]")); // x-path for selection in 2nd Gender
  a.click(e1).build().perform();
  Thread.sleep(3000);
  a.sendKeys("f").build().perform();
  a.sendKeys(Keys.ENTER).build().perform();
  Thread.sleep(5000);
  ab.close();
  
   

		
		
		

	}

}
