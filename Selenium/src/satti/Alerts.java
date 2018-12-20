package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;



public class Alerts 
{

	public static void main(String[] args) 
	{
	   System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
	   ChromeDriver driver=new ChromeDriver();
	   
	   driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
	   driver.findElement(By.xpath("//*[@type='button']")).click(); //x-path for Confirmation Alert
	   System.out.println(driver.switchTo().alert().getText());   // alert message is getting in Console
	   driver.switchTo().alert().accept(); // whether it is Ok or Cancel
	   // sati.switchTo().alert().dismiss(); // dismiss the alert*/
	   driver.manage().window().maximize();	
	
	   
		
		
		
	}

}
