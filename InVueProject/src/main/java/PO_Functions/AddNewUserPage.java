package PO_Functions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.java.swing.plaf.windows.resources.windows;

import java.util.Random;

public class AddNewUserPage extends WebElementActions {

	WebDriver driver;
	  public static Logger logger = Logger.getLogger(AddNewUserPage.class);

	public AddNewUserPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		PropertyConfigurator.configure("log4j.properties");
	}
	

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[1]/div/nav/ul/li[3]/a/p")
	WebElement lnkUser;

	@FindBy(xpath = "//span[@class='capitalize']")
	WebElement lnkAddUser;

	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[3]/input")
	WebElement txtfirstname;
	
	@FindBy(xpath ="//*[@id='scroller']/div/div[5]/input")
	WebElement txtMiddlename;

	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[7]/input")
	WebElement txtlastname;

	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[9]/input")
	WebElement txtemployeeid;

	@FindBy(xpath = "//*[@id=\"UserTypeId\"]")
	WebElement usertype;
	
	@FindBy(xpath="//*[@id='enabled']")
	WebElement Accountenable;

	@FindBy(xpath = "//button[@class='button primary']")
	WebElement btnsave;

	@FindBy(xpath = "//*[@id='modal-container']/div/div/button")
	WebElement btndone;

	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[12]/div[3]/button")
	WebElement btnLevelofAccess;
	

	@FindBy(xpath = "//*[@id=\"modal-container\"]/div[2]/div/button[2]")
	WebElement btnSetStore;

	public void clickuser() {
		lnkUser.click();
	}

	public void clickadduser() {
		lnkAddUser.click();
	}

	public void firstname(String fname) {
		txtfirstname.sendKeys(fname);
		logger.info("first name added");
	}
	
	public void middlename(String mname) {
		txtMiddlename.sendKeys(mname);
		logger.info("Middle name added");
	}

	public void lastname(String lname) {
		txtlastname.sendKeys(lname);
		logger.info("last name added");

	}

	public void employeeid(String eid) {
		txtemployeeid.sendKeys(eid);
		logger.info("employee added");

	}

	public void usertype() {
		usertype.click();

		Select menu = new Select(usertype);
		menu.selectByVisibleText("User");
		logger.info("user type added");

	}
	
	public void checkAccountEnabled() {
		
	    Select select = new Select(driver. findElement(By. xpath("//*[@id='enabled']")));
	    WebElement option = select. getFirstSelectedOption();
	    String defaultItem = option. getText();
	    logger.info("Account Enabled :-"+defaultItem );
	   
	}
	
	public void checkrestrictedmode() {
		
		Select select = new Select(driver. findElement(By. xpath("//*[@id=\"sounder\"]")));
	    WebElement option = select. getFirstSelectedOption();
	    String defaultItem = option. getText();
	    logger.info("Restricted Mode:-"+defaultItem );
	}
	
	public void checkappsession() {
		
		Select select = new Select(driver. findElement(By. xpath("//*[@id=\"duration\"]")));
	    WebElement option = select. getFirstSelectedOption();
	    String defaultItem = option. getText();
	    logger.info("Key/App Session:-"+defaultItem );
	}
	
	public void ClickLevelofAccess() throws InterruptedException { 
		  
			
			  String parentWindowHandler = driver.getWindowHandle(); // Store your parent
			   String subWindowHandler = null;
			 
			
			   btnLevelofAccess.click();

			
			  Set<String> handles = driver.getWindowHandles(); // get all window handles
			  Iterator<String> iterator = handles.iterator(); while (iterator.hasNext()) {
			  subWindowHandler = iterator.next(); }
			  driver.switchTo().window(subWindowHandler);
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  selectDivision();
			  selectRegion();
			  selectStore();
			  ClickSetStore();
			  
			  driver.switchTo().window(parentWindowHandler);
			  
	  }
	 
	public void selectDivision() throws InterruptedException
		  
		  {
			    WebElement element=driver.findElement(By.xpath("//*[@id=\"react-select-2--value\"]/div[1]"));
		        element.click();
		        driver.findElement(By.xpath("//*[text()='Test Division']")).click();
		        logger.info("Division selected!!");
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		  }
		 

	public void selectRegion() throws InterruptedException {
		
		
			WebElement element=driver.findElement(By.xpath("//*[@id=\"react-select-3--value\"]/div[1]"));
	        element.click();
	        driver.findElement(By.xpath("//*[text()='Test Region']")).click();
	        logger.info("Region selected!!");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 
		
	}

	public void selectStore() throws InterruptedException {
		
		
			WebElement element1=driver.findElement(By.xpath("//*[@id=\"react-select-4--value\"]/div[1]"));
	        element1.click();
	        WebDriverWait wait = new WebDriverWait(driver, 15);
	        WebElement store=    driver.findElement(By.xpath("//*[text()='Store 54']"));
	        wait.until(ExpectedConditions.elementToBeClickable(store));
	        logger.info("Store selected!!");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	public void Clicksave() {
		btnsave.click();
	}

	public void ClickSetStore() throws InterruptedException {
		
		btnSetStore.click();
		logger.info("Clicked on Set Store!! ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	public void ClickDone() {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		Actions action = new Actions(driver);
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
	
		action.moveToElement(btndone).click().perform();

		driver.switchTo().window(parentWindowHandler);
	}

	public void Adduser() throws InterruptedException {
		
	   	Random random = new Random();
		  clickuser();
		  clickadduser();
		  firstname("Test");
		  middlename("Testing");
		  lastname("User"); 
		  employeeid("TestUser" +  random.nextInt(100));
		  usertype();
		  checkAccountEnabled();
		  checkrestrictedmode();
		  checkappsession();
		  ClickLevelofAccess();
		  Clicksave();
		  ClickDone();
		 
	}

}
