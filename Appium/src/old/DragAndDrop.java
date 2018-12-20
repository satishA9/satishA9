package old;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class DragAndDrop {

	public static void main(String[] args)    throws Exception
	{

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","a033682e0904");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","7.1.2");
		dc.setCapability("appPackage", "com.miui.calculator");
		dc.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
	    URL u = new URL("http://0.0.0.0:4723/wd/hub");
		// create Driver object
		AndroidDriver driver;
		while(2>1)
			{
			  try
			    {
				    driver=new AndroidDriver(u,dc);
				    break;
			    }
			    catch(Exception ex)
			    {
				 
			    } 
			  
			} 
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Thread.sleep(30000);
		driver.findElement(By.xpath("//*[@content-desc='VodQAReactNative']")).click();  // xpath for Vodqa App
		// Automation
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']"))); // xpath for Login
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='dragAndDrop']")));// xpath for DragandDrop
			driver.findElement(By.xpath("//*[@content-desc='dragAndDrop']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Drag me!']"))); 
			WebElement e1 = driver.findElement(By.xpath("//*[@text='Drag me!']"));  // created dom for "Drag Me"
			WebElement e2 = driver.findElement(By.xpath("//*[@text='Drop here.']")); // created dom for" Drop Me"
	     	TouchAction ta = new TouchAction(driver);
			Duration d = Duration.of(10,ChronoUnit.SECONDS);   //duration represents lapse of time. Internally, the duration is stored in milliseconds.
			ta.press(e1).waitAction(d).moveTo(e2).release().perform();
			try 
			{
			      if(driver.findElement(By.xpath("//*[@text='Circle dropped']")).isDisplayed())
			      {
				   System.out.println("operation was finished");
			      }
			      else
			      { 
			    	System.out.println("operation was not finished");
			      }
			}	
			      catch(Exception ex)
			      {
			    	System.out.println(ex.getMessage());
			      }
			   
			   // closeApp
			    driver.closeApp();
		
		}
		
		        catch(Exception p)
		        {
		        	
		        	 System.out.println(p.getMessage());
		        }
			    

	}

}
