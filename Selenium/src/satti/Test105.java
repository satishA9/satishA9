package satti;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test105 {

	public static void main(String[] args)
	{
		 try
		 {
			   Scanner sc=new Scanner(System.in);
			   System.out.println("Enter browser name");
			   String x=sc.nextLine();
			   WebDriver driver=null;
			    if(x.equals("chrome"))
			    {
			    System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
			    driver= new ChromeDriver();
			    }
			    else if(x.equals("firefox"))
			    {
			    	System.setProperty("webdriver.gecko.driver", "F://geckodriver.exe");
			    	driver=new FirefoxDriver();
			    }
			    else if(x.equals("ie"))
			    {
			    	System.setProperty("webdriver.ie.driver", "F://iedriverserver.exe");
			    	driver=new InternetExplorerDriver();
			    }
			    else
			    {
			    	System.out.println("unknown browser");
			    	System.exit(0);
			    	
			    }
			   // Create objects to page classes
			   Homepage hp=new Homepage(driver);
			   Loginpage lp= new  Loginpage(driver);
			   Composepage cp=new Composepage(driver);
			   
			   // Launchsite
			   driver.get("http://www.gmail.com");
			   WebDriverWait w=new WebDriverWait(driver,10);
			   w.until(ExpectedConditions.visibilityOf(hp.uid));
			   driver.manage().window().maximize();
			   //DO lOGIN
			   hp.filluid("yvnsatish");
			   hp.clickuidnext();
			   w.until(ExpectedConditions.visibilityOf(lp.pwd));
			   lp.fillpwd("11bg1a04a8");
			   lp.clickpwdnext();
			   w.until(ExpectedConditions.visibilityOf(cp.signout));
			   cp.clicksignout();
			   w.until(ExpectedConditions.visibilityOf(lp.pwd));
			   driver.close();
		      }
		      catch(Exception ex)	
		      {
			   System.out.println(ex.getMessage());
		      }

	} // main closing
 

}  // catch closing
