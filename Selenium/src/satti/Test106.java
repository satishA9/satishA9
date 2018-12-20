package satti;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Test106
{

	public static void main(String[] args) throws Exception
	{
		File f=new File("F:\\pom.xls   ");
		Workbook rwb= Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);
		int nour= rsh.getRows();
		// open Html for appending results using extent reports
		ExtentReports er=new ExtentReports("gmailres.html",false);
		ExtentTest et=er.startTest("Gmail test Test");
		// Automation with DDT IN POM
		try
		{
			// DDT for 2nd Row(Index is 1)
			for(int i=1;i<nour;i++)
			{
				// Get data from Sheet
				
				String bname= rsh.getCell(0, i).getContents();
				String u= rsh.getCell(1, i).getContents();
				String uc=rsh.getCell(2, i).getContents();
				String p=rsh.getCell(3, i).getContents();
				String pc= rsh.getCell(4, i).getContents();
				WebDriver driver=null;
				 if(bname.equals("chrome"))
				    {
				    System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
				    driver=new ChromeDriver();
				    }
				    else if(bname.equals("firefox"))
				    {
				    	System.setProperty("webdriver.gecko.driver", "F://geckodriver.exe");
				    	driver=new FirefoxDriver();
				    }
				    else if(bname.equals("ie"))
				    {
				    	System.setProperty("webdriver.ie.driver", "F://iedriverserver.exe");
				    	driver=new InternetExplorerDriver();
				    }
				    else
				    {
				   et.log(LogStatus.SKIP, "unknownbrowser");
				   er.endTest(et);
				   rwb.close();
				   er.endTest(et);
				   er.flush();
				   System.exit(0);
	             // create objects to page classes 
				   Homepage hp=new Homepage(driver);
				   Loginpage lp=new Loginpage(driver);
				   Composepage cp=new Composepage(driver);
				   // Launch site
				   driver.get("http://www.gmail.com");
				   WebDriverWait w=new WebDriverWait(driver,30);
				   w.until(ExpectedConditions.visibilityOf(hp.uid));
				   driver.manage().window().maximize();
				   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				   // Do Login
				   hp.filluid(u);
				   hp.clickuidnext();
				   Thread.sleep(1000);
			      // uid Testing
				   try
				   {
					 if(u.length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Enter an email')]")).isDisplayed())
					 {
						et.log(LogStatus.PASS, " Blank uid test passed");
					 }
					 else if(uc.equals("invalid") && driver.findElement(By.xpath("(//*[@class='dEOOab RxsGPe'])[1]")).isDisplayed())
                     {
	                    et.log(LogStatus.PASS," Invalid Test passed");
                     }
                     else if(uc.equals("valid") && lp.pwd.isDisplayed())
                     {
                    	et.log(LogStatus.PASS,"void uid test passed"); 
                     
                      // password Testing
                    	lp.fillpwd(p);
                    	lp.clickpwdnext();
                        Thread.sleep(5000);
                      try
                        {
                    	  if(p.length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).isDisplayed())
                    	   {
                    		 et.log(LogStatus.PASS, "Invalid pwd test password");
                    	   }
                    	   else if(pc.equals("valid") && cp.comp.isDisplayed())
                    	   {
                    		et.log(LogStatus.PASS, "valid pwd test password");
                    	    //Do Logout
                    		cp.clickprofile();
                    		w.until(ExpectedConditions.visibilityOf(cp.signout));
                    		cp.clicksignout();
                    	}
                    	else
                    	{
                    		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    		File dest=new File("gmailss3.png");
                    		FileUtils.copyFile(src, dest);
                    		et.log(LogStatus.FAIL, "pwd test failed"+et.addScreenCapture("gmailss3.png"));
                    		
                    	}
                        
                      }
					  catch(Exception ex2)	 
                      {
						File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                  		File dest=new File("gmailss3.png");
                  		FileUtils.copyFile(src, dest);
                  		et.log(LogStatus.ERROR, "pwd test interrupted"+et.addScreenCapture("gmailss4.png"));  
                      }
                      } // else closing
					 
                      else
                      {
                    	    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    		File dest=new File("gmailss1.png");
                    		FileUtils.copyFile(src, dest);
                    		et.log(LogStatus.ERROR, "pwd test interrupted"+et.addScreenCapture("gmailss1.png"));  
                      }
				 }
						 
		
				   catch(Exception ex)
				    { 
					File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
               		File dest=new File("gmailss2.png");
               		FileUtils.copyFile(src, dest);
               		et.log(LogStatus.ERROR, "pwd test interrupted"+et.addScreenCapture("gmailss2.png"));  
                   }
				   }
				 // close site
				 driver.close();
			} // loop closing 
		} // Try block closing
		
		catch(Exception ex)
		{
			et.log(LogStatus.ERROR, ex.getMessage());
		}
				   
		rwb.close();
		er.endTest(et);
		er.flush();

	}

}
