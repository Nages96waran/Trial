package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.annotations.VisibleForTesting;

public class FirstTestClass {
//	public ChromeDriver driver;
//    public void invokeBrowser() {
//
//        System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Tools and Lib\\chromedriver.exe");
//        driver = new ChromeDriver();      
//        driver.manage().window().maximize();
//        driver.get("https://apps.volworks.com/#/login");
//    }
//	
//    public void provideUserDetails() {
//		
//        WebElement usernameElement = driver.findElement(By.name("email"));
//        usernameElement.sendKeys("nages96waran@gmail.com");
//        
//        WebElement userpasswordElement = driver.findElement(By.name("password"));
//        userpasswordElement.sendKeys("nages@1234");
//        
//        WebElement clickLogin = driver.findElement(By.className("login-btn"));
//        clickLogin.click();
//    }

	public static void main(String[] args) throws InterruptedException {
		
//		FirstTestClass obj = new FirstTestClass();
//		obj.invokeBrowser();
//		Thread.sleep(3000);
//		obj.provideUserDetails();
//		
		int dte = 72; 
		double price = 886.85;
		double strike = 920;
		double cerRecentYr = 2.8;
		double cerRecentMinusOneYr = 2.3;
		double cerRecentMinusTwoYr = 13.5;
		double cerRecentMinusThreeYr = 6.2;
		double cerRecentMinusFourYr = 5.5;
		double premiumAsPercOfStockPrice = 2.3;
		double percUpBE = 6;
		double probOfStockGTBE = 26.6;
		
		double cCerRecentYr;//2023
		double cCerRecentMinusOneYr;//2022
		double cCerRecentMinusTwoYr;//2021
		double cCerRecentMinusThreeYr;//2020
		double cCerRecentMinusFourYr;//2019
		double trRecency;
		double trPfitm;
		double tr;
		double ratings;
	
		if ((price * (1 + cerRecentYr)) < strike) {
			 cCerRecentYr = premiumAsPercOfStockPrice;
		} else {
			 cCerRecentYr = percUpBE - cerRecentYr;
		}

		if ((price * (1 + cerRecentMinusOneYr)) < strike) {
			 cCerRecentMinusOneYr = premiumAsPercOfStockPrice;
		} else {
			 cCerRecentMinusOneYr = percUpBE - cerRecentMinusOneYr;
		}

		if ((price * (1 + cerRecentMinusTwoYr)) < strike) {
			 cCerRecentMinusTwoYr = premiumAsPercOfStockPrice;
		} else {
			 cCerRecentMinusTwoYr = percUpBE - cerRecentMinusTwoYr;
		}

		if ((price * (1 + cerRecentMinusThreeYr)) < strike) {
			 cCerRecentMinusThreeYr = premiumAsPercOfStockPrice;
		} else {
			 cCerRecentMinusThreeYr = percUpBE - cerRecentMinusThreeYr;
		}

		if ((price * (1 + cerRecentMinusFourYr)) < strike) {
			 cCerRecentMinusFourYr = premiumAsPercOfStockPrice;
		} else {
			 cCerRecentMinusFourYr = percUpBE - cerRecentMinusFourYr;
		}
		
		 trRecency = ( (cCerRecentYr * 5) + (cCerRecentMinusOneYr * 4) + (cCerRecentMinusTwoYr * 3) + (cCerRecentMinusThreeYr * 2) + (cerRecentMinusFourYr * 1) ) / 15;
		 trPfitm = trRecency / probOfStockGTBE;

		if(dte > 90) {
		  tr = trPfitm * 0.5;
		} else if(dte > 60 && dte <= 90) {
			tr = trPfitm * 0.75;
		} else if (dte > 40 && dte <= 60){
			tr = trPfitm * 0.85;
		} else {
			tr = trPfitm;
		}
		
		if(tr > 0.054) {
			 ratings = 5;
		} else if (tr > 0.049) {
			ratings = 4.5;
		} else if (tr > 0.042) {
			 ratings = 4;
		} else if (tr > 0.036) {
			 ratings = 3.5;
		} else if (tr > 0.025) {
			 ratings = 3;
		} else if (tr > 0) {
			 ratings = 2;
		} else {
			 ratings = 1;
		}
		System.out.println(ratings);
	}

}
