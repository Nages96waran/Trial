package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPage {
	
  public ChromeDriver driver;
  @Test(priority = 1)
  public void invokeBrowser() {

      System.setProperty("web-driver.chrome.driver", "D:\\Automation\\Tools and Lib\\chromedriver.exe");
      driver = new ChromeDriver();      
      driver.manage().window().maximize();
      driver.get("https://apps.volworks.com/#/login");
  }
  
  @Test(priority = 2)
  public void provideUserDetails() {
		
      WebElement usernameElement = driver.findElement(By.name("email"));
      usernameElement.sendKeys("nages96waran@gmail.com");
      
      WebElement userpasswordElement = driver.findElement(By.name("password"));
      userpasswordElement.sendKeys("nages@1234");
      
      WebElement clickLogin = driver.findElement(By.className("login-btn"));
      clickLogin.click();
  }
}
