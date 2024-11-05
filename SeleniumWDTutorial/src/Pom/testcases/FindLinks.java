package Pom.testcases;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class FindLinks {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeTest
	public void set() {
		driver = new ChromeDriver();
		baseUrl = "https://apps.volworks.com/#/login";	
		
		driver.manage().window().maximize();       
	}
	
	public void testFindLink() {		
		driver.get(baseUrl);
//		searchPage.navigateTotab(driver);
		List <WebElement> linkList = clickableLinks(driver);
		for (WebElement link: linkList) {
			String href = link.getAttribute("href");
			try {
				System.out.println("The URL " + href + " returned" + linkStatus(new URL(href)));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static List<WebElement> clickableLinks(WebDriver driver) {
		List<WebElement> linksToClicks = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		
		for(WebElement e: elements) {
			if(e.getAttribute("href") != null) {
				elements.add(e);
			}
		}
		return linksToClicks;
	}
	
	public static String linkStatus(URL url) {
		try {
			HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
			
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}

}
