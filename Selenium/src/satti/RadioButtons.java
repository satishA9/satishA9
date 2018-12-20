package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.echoecho.com/htmlforms10.htm");
		//driver.findElement(By.xpath("//*[@value='Cheese']")).click(); // x-path for Cheese
         int count= driver.findElements(By.xpath("//input[@name='group1']")).size(); // getting size we used  
        for(int i=0;i<count;i++)
        {
        	//driver.findElements(By.xpath("//input[@name='group1']")).get(i).click(); // getting size and perform 
        	String x= driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");// getAtrtribute print the text in the console part
        	if(x.equals("Cheese"))
        	{
        		driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();

        		
        	}   
        	
        }	
        	
        	
        	
        }
    }
        

/*int count =driver.findElements(By.xpath("//input[@name='group1']")).size();

for(int i=0;i<count;i++)

{

//driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();

String text=driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");

if(text.equals("Cheese"))

{

driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();

}*/


