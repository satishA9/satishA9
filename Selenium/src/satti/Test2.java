package satti;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		int w = cd.manage().window().getSize().getWidth();
		int h = cd.manage().window().getSize().getHeight();
		System.out.println("W+  +H");
		Dimension d = new Dimension(200,400);
		int x = cd.manage().window().getPosition().getX();
		int y = cd.manage().window().getPosition().getY();
		Point p = new Point(300,400);
		cd.manage().window().setPosition(p);
		cd.close();
		

	}

}
