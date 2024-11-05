package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login{
	WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="email")
	WebElement emailField;
	
	@FindBy (name="password")
	WebElement passwordField;
	
	@FindBy (className="login-btn")
	WebElement clickLogin;
	
	public void provideUserName(String userName) {
		emailField.sendKeys(userName);
	}
	
	public void providePassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLogin() {
		clickLogin.click();
	}
}
