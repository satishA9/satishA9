package testngwithpom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class Testngdataproviderindifferentclass 
{
	public WebDriver driver;
	//Homepage hp;
	//Sendsmspage sp;
	@DataProvider(name="way2sms")
	public Object[][] satish()
	{
		return new Object[][]
				{
			{"8668218023","Preeti123","8341111338","hai"}
				};
	}
}
