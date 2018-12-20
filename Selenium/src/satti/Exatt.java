package satti;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exatt {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.exxat.com/");

	}

}
