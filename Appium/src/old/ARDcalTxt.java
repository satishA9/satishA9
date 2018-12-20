package old;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ARDcalTxt {

	public static void main(String[] args) throws Exception
	{


		// details of AVD and App
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME, "");
			    dc.setCapability("deviceName", "a033682e0904");
			    dc.setCapability("devicePlatform", "android");
			    dc.setCapability("plaformName", "7.1.2");
			    dc.setCapability("appPackage", "com.miui.calculator");
			    dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
			    //start Appium Server
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
			    
			         // Locate elements
			    
			           try
			             {
			    	         driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			    	         driver.findElement(By.xpath("//*[@text='9']")).click();
			    	         driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
			             	 Thread.sleep(10000);
			 	             driver.findElement(By.xpath("//*[@text='4']")).click();
			    	         Thread.sleep(10000);
			 	             driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
			 	             Thread.sleep(10000);
			 	             String x = driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
			 	             driver.closeApp();
			         }
			         
			          catch(Exception ex)
			         
			           {
			    	       System.out.println(ex.getMessage());
			           }

	}

}
