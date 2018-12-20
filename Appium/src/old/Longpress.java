package old;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Longpress 
{

	public static void main(String[] args) throws Exception 
	{

		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME," ");
		dc.setCapability("deviceName", "a033682e0904");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.1.2");
		dc.setCapability("appPackage", " com.miui.calculator");
		dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		// start Appium Server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		// Create Driver Object
		
		     
		
	
		
		
		
		
		
		
		
		
	}

}
