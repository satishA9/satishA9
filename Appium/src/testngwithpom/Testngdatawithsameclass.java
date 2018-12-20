package testngwithpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testngdatawithsameclass 
{
	//Homepage hp;
	//Sendsmspage sp;
public WebDriver driver;
Homepage hp;
Sendsmspage sp;
@DataProvider(name="way2smspreeti")
public Object[][] satish()
{
	return new Object[][]
			{
		{"8668218023","Preeti123","8341111338","hai"}
			};
}
@BeforeTest
public void launch()
{
	System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
     driver=new ChromeDriver();
	driver.get("http://www.way2sms.com/send-sms");
     hp=new Homepage(driver);
     sp=new Sendsmspage(driver);
}
@Test(dataProvider="way2smspreeti")
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
