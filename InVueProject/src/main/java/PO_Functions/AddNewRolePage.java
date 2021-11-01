package PO_Functions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewRolePage extends WebElementActions {


	WebDriver driver;

	public AddNewRolePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[1]/div/nav/ul/li[4]/a/p")
	WebElement lnkRole;
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/nav/div[1]/div[1]/button/span")
	WebElement lnkAddRole;
	
	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[1]/input")
	WebElement txtRolename;
	
	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[2]/input")
	WebElement txtDesc;
	
	@FindBy(xpath = "//*[@id=\"removeListItem-f7d4456b-cfcb-45ad-a6ae-b555ea75dc68\"]/img[2]")
	WebElement SelZone;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div[2]/div/button[2]")
	WebElement btnSaveRole;

	
	public void clickrole() {
		lnkRole.click();
	}
	
	public void clickaddrole() {
		lnkAddRole.click();
	}
	
	public void roleName(String Rname) {
		txtRolename.sendKeys(Rname);
		logger.info("Role name Added.");
	}
	
	public void roleDesc(String desc) {
		txtDesc.sendKeys(desc);
		logger.info("Role Desc Added.");
	}
	
	
	public void clickzone() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Actions action = new Actions(driver);
		action.moveToElement(SelZone).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(SelZone));
		
		
	}
	
	public void clickSave() {
		btnSaveRole.click();
	}
	
	public void  addNewRole(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clickrole();
		clickaddrole();
		roleName("Tej Role");
		roleDesc("This only for Testing.");
		clickzone();
		clickSave();
		
		
	}
}


