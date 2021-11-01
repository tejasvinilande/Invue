package PO_Functions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditRolePage extends WebElementActions {

	WebDriver driver;
	public static Logger logger = Logger.getLogger(EditUserPage.class);
	
	

	
	public EditRolePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		PropertyConfigurator.configure("log4j.properties");
		
	}

	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[1]/div/nav/ul/li[4]/a/p")
	WebElement lnkRole;
	
	@FindBy(xpath ="//*[@id='app']/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/input")
	WebElement txtSearchRole;
	
	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[1]/input")
	WebElement txtRolename;
	
	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[2]/input")
	WebElement txtDesc;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div[2]/div/button[2]")
	WebElement btnSaveRole;

	
	public void clickrole() {
		lnkRole.click();
	}
	
	
	public void searchrole(String role) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/input")));
		txtSearchRole.sendKeys(role);
		logger.info("succesfully Search for user.");

	}
	
	public void selectRole() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		Actions action = new Actions(driver);
		WebElement role=driver.findElement(By.xpath("//h2[contains(text(),'Tej Role')]"));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Tej Role')]")));
		action.moveToElement(role).click().perform();
	}
	
	public void roleName(String Rname) {
		
		txtRolename.clear();
		txtRolename.sendKeys(Rname);
		logger.info("Role Name Edited!");
	}
	
	public void roleDesc(String desc) {
		txtDesc.clear();
		txtDesc.sendKeys(desc);
		logger.info("Role Desc Edited!");
	}
	
	public void clickSave() {
		btnSaveRole.click();
	}
	
	public void  EditRole() throws InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clickrole();
		searchrole("Tej");
		selectRole();
		roleName("Test Role");
		roleDesc("Testing.");
		clickSave();
		
		
	}
	
}
