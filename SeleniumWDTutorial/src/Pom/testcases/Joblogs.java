package Pom.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.General;
import Pom.pages.HomePageFactory;
import Pom.pages.LoginPageFactory;
import Pom.pages.SideMenuPageFactory;

public class Joblogs {
	
	public static WebDriver driver;
	public static final String baseLoginUrl = "https://apps.volworks.com/#/login";
	public static final String baseLogoutUrl = "https://apps.volworks.com/#/logout";
	
	LoginPageFactory loginpage;
    SideMenuPageFactory sideMenu;
    HomePageFactory homePageFactory;
    General general;
    
    @BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get(baseLoginUrl);
        
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

	}
	
	@Test(priority = 2)  
	public void navigateToJobLogs() throws InterruptedException {
		sideMenu.clickJobLogs();
		Thread.sleep(Duration.ofSeconds(7));		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority = 3)
	public void switchToTab() throws InterruptedException {
		general.switchTab(driver, "Job Logs");
		Thread.sleep(Duration.ofSeconds(10));
	}
	
	@Test(priority = 4)
	public void checkTableHeaderColumns() {
		homePageFactory.getTableHeaderColumns();
	}
	
	

}
