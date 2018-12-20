package satti;

import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test8
{

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("No. of items to select");
		int n=Integer.parseInt(sc.nextLine());
		ArrayList<String> al = new ArrayList();
		System.out.println("Enter items to be selected");
		
		for(int i=0;i<n;i++)
		{
			al.add(sc.nextLine());
			
		}
		// Launch site
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']")).click();
	    // xpath for Multiselection
		Actions a=new Actions(driver);
		// select items
		for(int i=0;i<n;i++)
		{
			while(2>1) // infinte loop
			{
		    // xpath for multiselection for one selected item
			String x= driver.findElement(By.xpath("(//*[@class='item selected'])[1]")).getAttribute("data-value"); 
			if(x.equalsIgnoreCase(al.get(i)))
			{
		       a.sendKeys(Keys.ENTER).build().perform();
				break;
			}
			else
			{
				a.sendKeys(Keys.DOWN).build().perform();
			}
						
			
			}		
			
		 }
	
	}
	
	}


