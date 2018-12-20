package satti;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Composepage
{
	public WebDriver driver;
	  @FindBy(xpath="//*[text()='Compose']")
	  public WebElement comp;
	  @FindBy(xpath="//*[@class='gb_9a gbii']")
	  public WebElement profile;
	  @FindBy(xpath="//*[text()='Sign out']")
	  public WebElement signout;
	  public Composepage(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	  }
		public void clickprofile()
		{
			profile.click();
		}
		
		public void clicksignout()
		{
			signout.click();
		}

	
	

}
