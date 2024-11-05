package basicweb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NavigateReports extends LoginPage {
 
  @Test
  public void selectJobLogs() throws InterruptedException {
	  Thread.sleep(3000);
	  WebElement clickJobLogs = driver.findElement(By.xpath("//a[@href=\"#/jobs-logs?title=Job Logs\"][1]"));
	  clickJobLogs.click();
  }
//  @Test
//  public void selectCCReport() throws InterruptedException {
//		Thread.sleep(3000);	
////		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
//		WebElement clickCC = driver.findElement(By.xpath("//a[@href=\"#/covered-call-report?title=Covered Calls\"][1]"));
//		clickCC.click();
//		
//		List<String> handles = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(handles.get(2));
//
//		String url = driver.getCurrentUrl();
//		System.out.println(url);
//	}
}
