package Pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public static WebElement element = null;
	
	public static WebElement usernameInput(WebDriver driver) {
		element = driver.findElement(By.name("email"));
		return element;
	}
	
	public static WebElement passwordInput(WebDriver driver) {
		element = driver.findElement(By.name("password"));
		return element;
	}
	//another option
	public static void enterPasswordInput(WebDriver driver, String password) {
		element = passwordInput(driver);
		element.sendKeys(password);
	}
	
	public static WebElement loginButton(WebDriver driver) {
		element = driver.findElement(By.className("login-btn"));
		return element;
	}
	
	public static void clickLoginButton(WebDriver driver) {
		element = loginButton(driver);
		element.click();
	}
}
