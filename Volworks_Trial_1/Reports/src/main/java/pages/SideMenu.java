package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenu {
	WebDriver driver;
	
	public SideMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[@class=\'side-menu-item-title ng-star-inserted\'][1]")
	WebElement payoffTool;

	@FindBy (xpath = "//a[@href=\'#/booter-lq?title=(NEW) Booster\'][1]")
	WebElement newBoosters;
	
	@FindBy (xpath = "//a[@href=\'#/new-covered-call?title=(NEW) Covered Call\'][1]")
	WebElement newCC;
	
	@FindBy (xpath = "//a[@href=\'#/zero-cost-collar?title=Zero-Cost Collars\'][1]")
	WebElement newZcc;
	
	@FindBy (xpath = "//a[@href=\'#/put-notional-cost?title=(NEW) Puts-Notional Cost\'][1]")
	WebElement newPutNotional;
	
	@FindBy (xpath = "//div[@class=\'side-menu-item open\']/a[@href=\'#/jobs-logs?title=Job Logs\'][1]" )
	WebElement jobLogs;
		
	public void clickPayoffTool() {
		payoffTool.click();
	}
	
	public void clickNewBoosters() {
		newBoosters.click();
	}
	
	public void clickNewCC() {
		newCC.click();
	}
	
	public void clickNewZcc() {
		newZcc.click();
	}
	
	public void clickNewPutNotional() {
		newPutNotional.click();
	}
	
	public void clickJobLogs() {
		jobLogs.click();
	}
}
