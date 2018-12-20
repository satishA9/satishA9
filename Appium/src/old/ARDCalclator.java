package old;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ARDCalclator {

	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first input");
		String x=sc.nextLine();
		System.out.println("Enter second input");
		String y=sc.nextLine();
        // Details of AVD and App
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "a033682e0904");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","8.1.0");
		dc.setCapability("appPackage"," com.miui.calculator");
		dc.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
	    //start Appium Server
	    Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
	    URL u = new URL("http://0.0.0.0:4723/wd/hub");
	    //create driver object
	    AndroidDriver driver;
	    while(2>1)
	    	
	      {
	    	try
	    	
	    	  {
	    		driver= new AndroidDriver(u,dc);
	    		break;
	    	  }
	    	   catch(Exception ex)
	    	  {
	    		
	    	  }
	    		
	      }  
	    	
	         // Locate and operate elements
	          try
	          {
	    	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    	     for(int i=0; i<x.length();i++)
	    	     {
	    	    	     char c =x.charAt(i);
	    	    	     driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
	    	     }
	    	            driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
	    	         for(int i=0; i<y.length();i++)
		    	     
	    	          {
		    	    	 char c = y.charAt(i);
		    	    	 driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
		    	    	
		    	      }
		    	          driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
	    	        
		    	          String z= driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).getAttribute("text");
		    	          if(Integer.parseInt(z)==Integer.parseInt(x)+Integer.parseInt(y))
		    	     {
		    	    	  System.out.println("Test passed");
		    	    	  File src = driver.getScreenshotAs(OutputType.FILE);
		    	    	  File dest = new File("satish.png");
		    	    	  FileUtils.copyFile(src, dest);
		    	     }
		    	          else
		    	          {
		    	        	  System.out.println("Test failed");
			    	    	  File src = driver.getScreenshotAs(OutputType.FILE);
			    	    	  File dest = new File("satish1.png");
			    	    	  FileUtils.copyFile(src, dest);
		    	          }
	    	                  driver.closeApp();
	    	               
	                      }
	                        catch(Exception ex) 
	                      {
	                        	
	                       System.out.println(ex.getMessage());   
	
	                      }
	    Runtime.getRuntime().exec("taskkill /F/ IM node.exe");
	    Runtime.getRuntime().exec("taskkill /F/ IM cmd.exe");

	}

}
