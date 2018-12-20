package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test12 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("yvnsatish"); // name for Customer            
		driver.findElement(By.name("submit")).click();    // submitting the click button
		driver.switchTo().alert().accept(); // alert message is coming 
        String x=driver.switchTo().alert().getText(); // alert message is capture 
        System.out.println(x); // dispaly the message in output
        driver.close();
	}

}
