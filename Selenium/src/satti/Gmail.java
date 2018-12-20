package satti;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http:\\www.gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys("starsathish107");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("11bg1a04a8");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("to")).sendKeys("yvnsatish@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("Batch");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@role='textbox']")).sendKeys("hi\n how are you");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='T-I J-J5-Ji aoO T-I-atl L3']")).click();
		
	}

}
