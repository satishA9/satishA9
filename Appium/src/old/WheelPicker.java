package old;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class WheelPicker {

	public static void main(String[] args)  throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter red/green/black/blue");
		String cname =sc.nextLine();
		int count=0;
		int percentage;
		Color ec=null;
		switch(cname)
		 {
		    case "black":
			ec=Color.black;
			break;
		    case "red":
			ec= Color.red;
			break;
		    case "blue":
		    	ec= Color.blue;
		    	break;
		    case "green":
		    ec=new Color(0,128,0);
		    break;
		    default:
		    System.out.println("wrong color");    	
		    System.exit(0);        //stop execution forcibly
		}
		// Details of ARD and App
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","a033682e0904");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","7.1.2");
		dc.setCapability("appPackage","com.miui.calculator");
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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@content-desc='VodQAReactNative']")).click();
		// Automation
		
		     try
	        	{
		       	    WebDriverWait wait = new WebDriverWait(driver,20);
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			        driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
	             	// swipe for wheel picker
			      while(2>1)
				  {
				 
				  try
				  {
					  driver.findElement(By.xpath("//*[@content-desc='wheelPicker']")).click();
					  break;
				  }
		          catch(Exception ex)
				  {
		        	TouchAction ta =new TouchAction(driver);
		        	driver.context("NATIVE_APP");
		        	int w=driver.manage().window().getSize().getWidth();
		        	int h=driver.manage().window().getSize().getHeight();
		        	int x1=(int)w/2;
		        	int y1=(int)(h*0.9);
		        	int x2=(int)w/2;
		        	int y2=(int)(h*0.4);
		        	ta.press(x1,y1).moveTo(x2,y2).release().perform();
				  }
			 }	  
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.Spinner']")));
		          driver.findElement(By.xpath("//*[@class='android.widget.Spinner']")).click();
		          // x-path for Dropdowns
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.ListView']")));
		         //  driver.findElement(By.xpath("//*[@class='android.widget.ListView']")).click(); // xpath for List
		          driver.findElement(By.xpath("//*[@text='"+cname+"']")).click();
		          WebElement e = driver.findElement(By.xpath("//*[@bounds='[0,270][1080,408]']"));  // bounds for red color
		          // Get the location of element on '
		          //the app screen
		          int x= e.getLocation().getX();
		          int y=e.getLocation().getY();
		          // Get width and height of the element
		          int eleWidth=e.getSize().getWidth();
		          int eleHeight=e.getSize().getHeight();
		          // GET entire screenshot
		          File screenshot= driver.getScreenshotAs(OutputType.FILE);
		          BufferedImage fullImg=ImageIO.read(screenshot);
		          BufferedImage eleScreenshot=fullImg.getSubimage(x,y,eleWidth,eleHeight);
		          // check image color to validate
		          for(int i=0;i<eleWidth;i++)
		          {
		        	  for(int j=0;j<eleHeight;j++)
		        	  {
		        	
		        	   Color ac =new Color(eleScreenshot.getRGB(i, j));
		        	   if(ac.getRed()==ec.getRed()&& ac.getBlue()==ec.getBlue() && ac.getGreen()==ec.getGreen())
                    {
	                  count=count+1;
	                  
                    }   
		       }		
		    }   		
	           	
	        	    System.out.println(count);
		            percentage=(count*100)/(eleWidth*eleHeight);
		            if(percentage>=85) 
		            {
		        	  System.out.println("color test was passed");
		            }
		            else
		            {
		            	 System.out.println("color test was not passed");
		            }
	        	  driver.closeApp();
	        	}
		     catch(Exception ex)
		     {
		    	 System.out.println(ex.getMessage());
		     }

	}

}
