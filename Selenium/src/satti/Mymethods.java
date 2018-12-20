package satti;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mymethods 
{
  public WebDriver driver;
  public WebDriverWait wait;
  @BeforeMethod
  public String launch(String e,String d,String c)
  {
	  if(e.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		  driver=new ChromeDriver();
	  }
	  else if(e.equals("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver","F:\\geckodriver.exe");
		  driver=new FirefoxDriver();
	  }
	  else if(e.equals("ie"))
	  {
		  System.setProperty("webdriver.ie.driver","F:\\iedriverserver.exe");
		  driver=new InternetExplorerDriver();
	  }
	  else
	  {
		  return("unknown browser");
	  }
	  driver.get(d);
	  wait=new WebDriverWait(driver,20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@name='mobileNo'])[1]")));
	  driver.manage().window().maximize();
	  return("done"); // when methods gets Executed
      }
	// To fill a text book 
     public String fill(String e,String d,String c)
     {
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
       driver.findElement(By.xpath(e)).sendKeys(d);
       return("Done");
     }
     @Test
	 public String click(String e,String d,String c) 
	 {
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
	       driver.findElement(By.xpath(e)).click();;
	       return("Done");
		
	 }
	  public String Validate(String e,String d,String c) throws Exception 
	  {
		  try
		  {
			  if(c.equals("all_valid") && driver.findElement(By.xpath("(//*[@class='btn-theme-sm btn-ls text-uppercase'])[1]")).isDisplayed())
               {
            	   return("passed");
               }
               else if(c.equals("mbno-blank") && driver.findElement(By.name("mobileNo")).isDisplayed())
               {
            	 return("passed");
               }
               else if(c.equals("mbno-invalid") && driver.findElement(By.xpath("//*[text()='Your mobile number is not register with us.']")).isDisplayed())
               {
            	   return("passed");
               }
               else if(c.equals("pwd-blank") && driver.findElement(By.xpath("(//b[text()='Enter password'])[2]")).isDisplayed())
               {
            	   return("passed");
               }
               else if(c.equals("pwd-invalid")	 && driver.findElement(By.xpath("(//*[contains(text(),'Incorrect number')])[1]")).isDisplayed())
               {
            	   return("passed");
               }
               else
               {
            	  String temp=this.screenshot();
            	  return("Test failed & goto"+temp+".png");
               }
		       } // Try closing 
		       catch(Exception ex)
		       {
		    	 
		    	   String temp=this.screenshot();
		    	   return("Test interrupted & goto"+temp+".png");
		       }
	   
	           } // validatLogin
	           public  String closesite(String e,String d,String c)
	           {
	        	  driver.close(); 
	        	  return("Done");
	           }

	           public String screenshot() throws Exception
	           {
	           Date d=new Date();
	           String ss=d.toString();
	           File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	           File dest=new File(ss+".png");
	           FileUtils.copyFile(src, dest);
	           return(ss);
	           }
	
}

