package Pom.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom.pages.HomePageFactory;
import Pom.pages.LoginPageFactory;
import Pom.pages.SideMenuPageFactory;
import Pages.General;

public class Testcase1PageFactory {
	public WebDriver driver;
	public String baseUrl;
	
	LoginPageFactory loginpage;
    SideMenuPageFactory sideMenu;
    HomePageFactory homePageFactory;
	General general;
	  
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		baseUrl = "https://apps.volworks.com/#/login";		
		driver.manage().window().maximize();
        driver.get(baseUrl);
        
        loginpage = new LoginPageFactory(driver);
        sideMenu = new SideMenuPageFactory(driver);
        homePageFactory = new HomePageFactory(driver);
     
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		loginpage.provideUsername("nageswaran96@gmail.com");
		loginpage.providePassword("nages@1234");
		loginpage.clickLoginBtn();
		Thread.sleep(10000);
//		homePageFactory.verifyReportBody(driver);

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
