package satti;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links
{

	public static void main(String[] args) throws Exception, IOException 
	{
		   System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
		   ChromeDriver driver=new ChromeDriver();
		   driver.get("https:///");
		   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		   driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		   List<WebElement> links=driver.findElements(By.tagName("a")); 
		   links.addAll(driver.findElements(By.tagName("img")));
		   System.out.println("number of links and images"+links.size());
		   List<WebElement> active=new ArrayList<WebElement>();
		   for(int i=0;i<links.size();i++)
		   {
			   if(links.get(i).getAttribute("href") != null)
			   {
				   active.add(links.get(i));
			   }
		   }
		   System.out.println("list of active links and images :" +active.size());
		   
		   for(int j=0;j<active.size();j++)
		   {
			   HttpURLConnection connection=(HttpURLConnection) new URL(active.get(j).getAttribute("href")).openConnection();
			   connection.connect();
			   String response=connection.getResponseMessage();
			   connection.disconnect();
			   System.out.println(active.get(j).getAttribute("href")+"--->" +response);
		   }
		   
		   
		   
   }

}
