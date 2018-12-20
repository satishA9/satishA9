package testngwithpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests 
{
 public	WebDriver driver;
	Homepage hp;
	Sendsmspage sp;
	@BeforeTest
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/send-sms");
	    hp=new Homepage(driver);
	    sp=new Sendsmspage(driver);
	}
	@Test(dataProvider="way2sms")
	public void search(String x,String y,String z,String w) throws Exception
	{
		hp.fillmobno(x);
		hp.fillmobpwd(y);
		hp.clicklogin();
		Thread.sleep(5000);
		sp.fillsendmob(z);
		sp.filltextsms(w);
		sp.clicksendsms();
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}    

