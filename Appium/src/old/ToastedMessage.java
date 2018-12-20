package old;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ToastedMessage {

	public static void main(String[] args) throws Exception 
	{
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME," ");
		dc.setCapability("deviceName", "a033682e0904");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","7.1.2");
		dc.setCapability("appPackage","com.miui.calculator");
		dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		// start Appium Server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		// driver object to AndroidDriver
		AndroidDriver driver;
		while(2>1)
		{
			try 
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception c) 
			{
				
			}
	
		}
		
		    driver.pressKeyCode(AndroidKeyCode.HOME);
			WebDriverWait wait= new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Phone']")));
			driver.findElement(By.xpath("//*[@content-desc='Phone']")).click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Contacts']")));
	        driver.findElement(By.xpath("//*[@text='Contacts']")).click();
		//swipe from bottom to Top for required contact
	        driver.context("NATIVE_APP");
	        int w=driver.manage().window().getSize().getWidth();
	        int h=driver.manage().window().getSize().getHeight();
	        TouchAction ta = new TouchAction(driver);
	        int x1=(int)(w/2);
	        int y1=(int)(h*0.8);
	        int x2=(int)(w/2);
	        int y2=(int)(h*0.4);
	        while(2>1)
	        {
	        	try
	        	{
	        	driver.findElement(By.xpath("//*[@text='Tirupathi']")).click();
	        	break;
	       
	        	}
	        	catch(Exception ex)
	        	{
	        		ta.press(x1,y1).waitAction(Duration.ofMillis(500)).moveTo(x2,y2).release().perform();
	        		Thread.sleep(3000);
	        		driver.findElement(By.xpath("//*[contains(@resource-id,'com.android')]")).click();
	        		
	        	}
	        		
	        	}		
	        		
	        		
	        		
	        		
	        	
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
		}
	}


