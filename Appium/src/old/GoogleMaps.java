package old;

import java.net.URL;

import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class GoogleMaps 
{

	public static void main(String[] args)  throws Exception
	{
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName","android");
		dc.setCapability("platformName","a033682e0904");
		dc.setCapability("platformVersion","7.1.2");
		dc.setCapability("locationServicesEnabled","true");
		dc.setCapability("locationServicesAuthorized ","true");
		dc.setCapability("appPackage","com.google.android.apps.maps");
		dc.setCapability("appActivity","com.google.android.maps.MapsActivity");
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
	    
	            // set location for Australia
	              Location L1 = new Location(-25.274398,133.775136,3000);
	             driver.setLocation(L1);
	             Thread.sleep(50000);
	           // set location for London
	             Location L2 = new Location(51.507351,-0.127758,3000);
	             driver.setLocation(L2);
	             Thread.sleep(50000);
	             driver.closeApp();
	            // stop Appium Server 
	              Runtime.getRuntime().exec("taskkill /F/ IM node.exe");
	     	      Runtime.getRuntime().exec("taskkill /F/ IM cmd.exe");
	}

}
