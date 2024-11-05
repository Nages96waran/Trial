package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;

public class SideMenu{
	WebDriver driver;
	
	@FindBy (xpath = "//a[@href='#/booster-report?title=Boosters'][1]") 
	WebElement booster;
	
	public void clickBoosterReport() {
		booster.click();
	}
	
	public SideMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
