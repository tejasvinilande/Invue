package PO_Functions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.ReadConfig;

public class BaseClass {

	
     ReadConfig pro= new ReadConfig();
	
	public String baseURL=pro.getApplicationURL();
	public String username=pro.getUserName();
	public String password=pro.getpassword();
	public static WebDriver driver;
	
//	public static Logger logger;
	public static Logger logger = Logger.getLogger(BaseClass.class);
	
	@BeforeClass
	public void setup() throws IOException {
		
		// Logger logger = Logger.getLogger(BaseClass.class);
	//	logger=Logger.getLogger("LockDemo");
		PropertyConfigurator.configure("log4j.properties");
		
		if(pro.getbrowser().equalsIgnoreCase("chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver",pro.getchromepath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("enable-automation");
			//options.addArguments("--headless"); //should be enabled for Jenkins
			options.addArguments("--disable-dev-shm-usage"); //should be enabled for Jenkins
			options.addArguments("--window-size=1920x1080"); //should be enabled for Jenkins
			options.addArguments("--disable-gpu");
	//		options.addArguments("--disable-notifications");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-extensions");
			options.addArguments("--dns-prefetch-disable");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
			driver=new ChromeDriver();
		
		}
		else if(pro.getbrowser().equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",pro.getfirefoxpath());
            driver = new FirefoxDriver();
			
		}
		else if(pro.getbrowser().equalsIgnoreCase("edge")) {
			

            System.setProperty("webdriver.edge.driver",pro.getedgepath());
            driver = new EdgeDriver();
		}
		
		driver.get(baseURL);

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public static void waitTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	public void captureScreen(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target =new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
		
	}
	
}
