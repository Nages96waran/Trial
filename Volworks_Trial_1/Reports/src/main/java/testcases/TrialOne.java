package testcases;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Login;
import pages.SideMenu;
import functions.Base;
import functions.General;


public class TrialOne {
	public WebDriver driver;
	public String baseUrl;
	
	Login loginpage;
    SideMenu sideMenu;
    HomePage homePageFactory;
	General general;
	Base base;
	  
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		baseUrl = "https://apps.volworks.com/#/login";		
		driver.manage().window().maximize();
        driver.get(baseUrl);
//		try {
//			base.initializeBrowser("chrome");
//		} catch (Exception e) {
//			base.initializeBrowser("edge");
//		}
    
        loginpage = new Login(driver);
        sideMenu = new SideMenu(driver);
        homePageFactory = new HomePage(driver);
     
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		loginpage.provideUsername("nageswaran96@gmail.com");
		loginpage.providePassword("nag@1234");
		loginpage.clickLoginBtn();
		Thread.sleep(10000);

	}
	
	@Test(priority = 2)
	public void navigateToCCReport() throws InterruptedException {
		sideMenu.clickNewCC();
		Thread.sleep(Duration.ofSeconds(7));		
	}
	  
	@SuppressWarnings("static-access")
	@Test(priority = 3)
	public void switchToTab() {
		general.switchTab(driver, "Covered Calls");
	}
	
	@Test(priority = 4)
	public void verifyReportBody() {
		homePageFactory.verifyReportBody(driver);
	}
	
	@SuppressWarnings("static-access")
	@Test(priority = 5)
	public void navigateToBoosterReport() throws InterruptedException {
		sideMenu.clickNewBoosters();
		Thread.sleep(Duration.ofSeconds(7));
		general.switchTab(driver, "Boosters");
	}

}
