package Headlessbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Headless {
	WebDriver driver;
	@BeforeMethod
	public void chromeRun()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\lib\\Chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("headless");
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		
	}
	@Test(priority=1)
	public void googleTitleTest()
	{
	System.out.println(driver.getTitle());
	
	}
	@Test(priority=2)
	public void FacebookTitleTest()
	{
	driver.navigate().to("https://www.facebook.com/");
		System.out.println(driver.getTitle());
	
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
