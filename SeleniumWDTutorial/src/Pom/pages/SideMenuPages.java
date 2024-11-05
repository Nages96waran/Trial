package Pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenuPages {
	
	public static WebElement element = null;
	
	public static WebElement optionStrategies(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class=\"side-menu-item-main-title\" ][1]"));
		return element;
	}
	
	public static void clickOptionStrategies(WebDriver driver) {
		element = optionStrategies(driver);
		element.click();
	}
	
	public static WebElement strategyPayoffTool(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class=\"side-menu-item-title ng-star-inserted\"][1]"));
		return element;
	}
	
	public static void clickStrategyPayoffTool(WebDriver driver) {
		element = strategyPayoffTool(driver);
		element.click();
	}
}
