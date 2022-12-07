package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase {
public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void launchApp() {
		driver.get("https://ebay.com");
		driver.manage().window().maximize();
		Assert.assertTrue(false);
		}
		
		@Test
		public void launchApp1() {
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			Assert.assertTrue(false);
			}
		@Test
		public void launchApp2() {
			driver.get("https://www.facebook.com");
			driver.manage().window().maximize();
			Assert.assertTrue(false);
			}
}
