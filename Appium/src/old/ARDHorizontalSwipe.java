package old;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ARDHorizontalSwipe
{

	public static void main(String[] args)  throws Exception
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName","a033682e0904");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.1.2");
		dc.setCapability("appPackage","com.miui.calculator");
		dc.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u = new URL("http://0.0.0.0:4723/wd/hub");
		    //create driver object
		    AndroidDriver driver;
		    while(2>1)
		    {
		    	try
		    	  {
		           
		    		driver = new AndroidDriver(u,dc);
		    		break;
		  
		    	   }
		    	
		    	   catch(Exception ex)
		    	   {
		    	 
		    	   }
		    }
		   
		    driver.pressKeyCode(AndroidKeyCode.HOME);
			try
			{
			   // swipe on App screen
			   int w = driver.manage().window().getSize().getWidth();
			   int h = driver.manage().window().getSize().getHeight();
			   TouchAction ta = new TouchAction(driver);
			   // swipe from Right to Left 5 Times
			   int x1 = (int)(w*0.9); //near to Right Edge
			   int y1 = (int)(h/2);
			   int x2 = (int)(w*0.3); // near to center to left edge
			   int y2 = (int)(h/2);
			   for(int i=1;i<=5;i++)
			       {
				   Duration d = Duration.of(3,ChronoUnit.SECONDS);
				   ta.press(x1,y1).moveTo(x2,y2).waitAction(d).release().perform();
			       }
		           // swipe left to right 5 time
			       /*x1= (int)(w*0.3);  // near to Left edge
			       x2 = (int)(w*0.6); // near to center or right edge
			       for(int i=1;i<=5;i++)
			       {
					   Duration d = Duration.of(3,ChronoUnit.SECONDS);
					   ta.press(x1,y1).moveTo(x2,y2).waitAction(d).release().perform();
					   
			       }*/
			     
				      // closeApp
					   driver.closeApp();
			}
				    
			    catch(Exception e)
			    {
			    	System.out.println(e.getMessage());
			    	
			    }

	       }

	}


