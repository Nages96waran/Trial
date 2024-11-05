package Pom.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pom.pages.LoginPage;
import Pom.pages.SideMenuPages;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase1 {
	WebDriver driver;
	
	@BeforeTest
	public void set() {
//		WebDriverManager.chromedriver().setup(); It throws Configuration Error
		System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Tools and Lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://apps.volworks.com/#/login");
	}
	
	@Test(priority = 1)
	public void test() throws InterruptedException {		
		LoginPage.usernameInput(driver).sendKeys("nageswaran96@gmail.com");
		LoginPage.enterPasswordInput(driver, "nages@1234");
		LoginPage.clickLoginButton(driver);
		Thread.sleep(10000);
		SideMenuPages.clickStrategyPayoffTool(driver);
		List<String> handles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(1));	
		String url = driver.getCurrentUrl();
		System.out.println("Current URL = " + url);
	}
	
//	@AfterTest
//	public void close() {
//		driver.quit();
//	}
}
