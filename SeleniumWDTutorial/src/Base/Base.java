package Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.velocity.runtime.directive.Foreach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.SideMenu;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver = null;
	public static final String baseUrl = "https://apps.volworks.com/#/login";
	public Properties prop;
	
    @BeforeTest
    public WebDriver initializeBrowser (String browser) {
    	
    	if(browser.equalsIgnoreCase("chrome")) {
    		
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    		
    	} else if (browser.equalsIgnoreCase("edge")) {
    		
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    	}
    	
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	return driver;
    }
    
    public void loadProjectDataProperties() {
    	
    	prop = new Properties();
    	String projectPath = System.getProperty("user.dir");
    	File file = new File(projectPath+"\\src\\resources\\ProjectData.properties");
    	try {
    		FileInputStream fis = new FileInputStream(file);
    		prop.load(fis);
    	} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
    }
    
    public String getTimeStamp() {
    	Date date = new Date();
    	String timeStampModified = date.toString().replaceAll(" ", "_").replaceAll(":", "_");
    	return timeStampModified;
    }

}
