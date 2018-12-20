package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox2 
{

	public static void main(String[] args) 
	{
		    System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
	        ChromeDriver driver = new ChromeDriver();
            driver.get("http://www.spicejet.com/");
            driver.manage().window().maximize();
            driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).click(); // x-path for "Senior Citizen" 
            // is Selected -whether element is displayed true of False
            System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());
	}

}
