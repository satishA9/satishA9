package old;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class HorizontalSwipe
{

	public static void main(String[] args) throws Exception 
	{
	
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "a033682e0904");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.1.2");
		dc.setCapability("appPackage", "com.miui.calculator");
		dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		// start Appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		// create driver object
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
	    // swipe App screen
		int w= driver.manage().window().getSize().getWidth();
		int h= driver.manage().window().getSize().getHeight();
		TouchAction ta = new TouchAction(driver);
        // swipe Left to Right
		int x1=(int)(w*0.9);
		int y1=(int)(h/2);
		int x2=(int)(w*0.3);
		int y2=(int)(h/2);
		ta.press(870,980).moveTo(110,980).release().perform();
		 //swipe Right to Left
		int a1=(int)(w*0.3);
		int b1=(int)(h/2);
		int a2=(int)(w*0.7);
		int b2=(int)(h/2);
		ta.press(250,950).moveTo(810,950).release().perform();
	}

}
