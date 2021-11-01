package PO_Functions;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.OS;
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

public class EditUserPage extends WebElementActions{
	
	WebDriver driver;
	public static Logger logger = Logger.getLogger(EditUserPage.class);

	
	public EditUserPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		PropertyConfigurator.configure("log4j.properties");
	}


	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/input")
	WebElement txtSearchUser;
	
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[1]/div/nav/ul/li[3]/a/p")
	WebElement lnkUser;

	@FindBy(xpath = "//span[@class='capitalize']")
	WebElement lnkAddUser;

	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[3]/input")
	WebElement txtfirstname;

	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[7]/input")
	WebElement txtlastname;

	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[9]/input")
	WebElement txtemployeeid;

	@FindBy(xpath = "//*[@id=\"UserTypeId\"]")
	WebElement usertype;

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

	public void searchuser(String user) {

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			txtSearchUser.sendKeys(user);
			logger.info("succesfully Search for user.");

		}
	
	public void selectuser() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement user=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/ul/div/div/li[2]/div[1]/div/h2"));
		action.moveToElement(user).click().perform();	
		String st=driver.findElement(By.xpath("//*[@id=\"scroller\"]/div/div[9]/input")).getAttribute("value");
		logger.info("Employee Id is : " + st);
	

	}
	
	public void changefirstname(String fname) {
		txtfirstname.clear();
		txtfirstname.sendKeys(fname);
		logger.info("firstname changed!!");
		
	}
	
	public void changelastname(String lname) {
		txtlastname.clear();
		txtlastname.sendKeys(lname);
		logger.info("lastname changed!!");
	}
	
	public void changeId(String eid) {
		txtemployeeid.clear();
		txtemployeeid.sendKeys(eid);
		logger.info("EmployeeId changed");
	}
	
	public void changeusertype() {
		usertype.click();

		Select menu = new Select(usertype);
		menu.selectByVisibleText("Support");
		logger.info("user type changed!!");
	}
	
	
	  public void ClickLevelofAccess () throws InterruptedException {
	  
	  
	  
	  String parentWindowHandler = driver.getWindowHandle(); // Store your parent
	  String subWindowHandler = null;
	  
	  Thread.sleep(5000); btnLevelofAccess.click();
	  
	  
	  Set<String> handles = driver.getWindowHandles(); // get all window handles
	  Iterator<String> iterator = handles.iterator(); 
	  
	  while (iterator.hasNext()) {
		  
	  subWindowHandler = iterator.next();
	  
	  }
	  
	  driver.switchTo().window(subWindowHandler);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //
	  ChangeDivision(); // changeRegion(); // selectStore(); //
	  ClickSetStore();
	  
	  driver.switchTo().window(parentWindowHandler);
	  
	  }
	 
	
	
	  public void ChangeDivision() throws InterruptedException
	  
	  {
	  

		    WebElement element=driver.findElement(By.xpath("//*[@id=\"react-select-2--value\"]/div[1]"));
	        element.click();
	        
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'South (A)')]")));

	        WebElement div=driver.findElement(By.xpath("//span[contains(text(),'South (A)')]"));
	        driver.manage().window().fullscreen();
	 
	 
	        if(div.isDisplayed()) {
				
				logger.info("div is displayed");
				div.click();
				 wait.until(ExpectedConditions.elementToBeClickable(div));
			}
			else {
				
				logger.info("Zone is not updated!!");
				
			}
			
	      //  driver.findElement(By.xpath("//span[contains(text(),'South (A)')]")).click();
	       
		  
			/*
			 * driver.findElement(By.xpath(
			 * "//*[@id=\"modal-container\"]/div[1]/div/table/tbody/tr[1]/td[2]/div/div/span[1]/span"
			 * )).click(); WebElement element=driver.findElement(By.xpath(
			 * "//*[@id=\"react-select-2--value\"]/div[1]")); element.click();
			 * 
			 * WebDriverWait wait = new WebDriverWait(driver, 50);
			 * 
			 * WebElement
			 * div=driver.findElement(By.xpath("//span[contains(text(),'South (A)')]")); new
			 * WebDriverWait(driver,
			 * 50).until(ExpectedConditions.visibilityOfElementLocated(By.
			 * xpath("//span[contains(text(),'South (A)')]")));
			 */
	        /*
	         * Select select = new Select(div); select.selectByVisibleText("South (A)");
	         * select.selectByIndex(0);
			         */
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[starts-with(@id, 'react-select-')]")));
			//driver.findElement(By.id("//span[starts-with(@id, 'react-select-')]")).click();	
			
			//div.click();
			//  Thread.sleep(5000);
			  
			
			  
			  //Select from dropdown
		    //  WebElement we=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'South (A)')]")));
		      /*we.click();
		      we.sendKeys("email");*/
				/*
				 * Actions actions = new Actions(driver); actions.moveToElement(we);
				 * actions.click(); actions.sendKeys("south"); actions.sendKeys(Keys.ENTER)
				 */;
		    //  actions.build().perform();
			  
			
			/*
			 * Actions action = new Actions(driver); WebElement optionsList
			 * =driver.findElement(By.xpath("//span[contains(text(),'South (A)')]"));
			 * action.moveToElement(optionsList); optionsList.submit(); Thread.sleep(5000);
			 */
	  logger.info("Division changed!!");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  }
	  
		public void ClickSetStore() throws InterruptedException {
			
			btnSetStore.click();
			logger.info("Clicked on Set Store!! ");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		

		public void Clicksave() {
			btnsave.click();
			
			logger.info("click on save!!");
		}
	 
	
	  public void Edituser() throws InterruptedException { 
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  clickuser();
		  Thread.sleep(5000);
		  searchuser("Test User");
		  Thread.sleep(5000);
		  selectuser();
		  changefirstname("New");
		  changelastname("Edit");
		  changeId("123445");
		//  changeusertype();
		 // ClickLevelofAccess();
		 // Clicksave();
	 
	  
	  }
	  
	 


}
