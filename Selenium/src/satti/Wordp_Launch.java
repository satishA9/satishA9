package satti;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Wordp_Launch 
{

	public static void main(String[] args) throws Exception 
	{
           DesiredCapabilities dc = new DesiredCapabilities();
           dc.setCapability(CapabilityType.BROWSER_NAME," ");
           dc.setCapability("deviceName", "a033682e0904");
           dc.setCapability("platformName", "android");
           dc.setCapability("platformVersion","7.1.2");
           dc.setCapability("appPackage","com.android.contacts");
           dc.setCapability("appActivity","com.android.contacts.activities.TwelveKeyDialer");
           // Start Appium server
           Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
           URL u = new URL("http://0.0.0.0:4723/wd/hub");
           // Create driver object to phoneApp
           AndroidDriver driver;
           while(2>1)
           {
        	    try
        	    {
        		   driver =new AndroidDriver(u,dc);
        		   break;
        	    }
        	      catch(Exception ex)
        	    {
        		   
        	    	  
        	    
           }
           }
        	// Automation 
             
              try
              
                {
        	       // back to home
        	        driver.pressKeyCode(AndroidKeyCode.HOME);
        	      
        	        
                
        	      // go to other app and operate elements
                        
                     WebDriverWait wait = new WebDriverWait(driver,20);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='WordPress']")));
                     driver.findElement(By.xpath("//*[@content-desc='WordPress']")).click();
                     Thread.sleep(5000);
                     driver.findElement(By.xpath("//*[@text='LOG IN']")).click(); 
                     // back to Home
                     
                    
            if(driver.isKeyboardShown())
            	  
                {
                	 driver.hideKeyboard();
                }
                 
                     driver.pressKeyCode(AndroidKeyCode.HOME);
                 // LaunchphoneApp and Close
                     
                     driver.launchApp();
                     driver.closeApp();
                     
                }
	                catch(Exception ab)
	                {
	                System.out.println(ab.getMessage());	
	                
	                }
	                
	                
	             Runtime.getRuntime().exec("taskkill /F/IM node.exe");
	             Runtime.getRuntime().exec("taskkill /F/IM cmd.exe");

	}

}
