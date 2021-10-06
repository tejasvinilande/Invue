package PO_Functions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage extends WebElementActions{
	
	WebDriver driver;
	public static Logger logger = Logger.getLogger(EditUserPage.class);

	
	public EditUserPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		PropertyConfigurator.configure("log4j.properties");
	}

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/ul/div/div/li[6]/div[1]/div/h2")
	WebElement lnkUser;
	
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

	public void clickonuser() {
		
		
	}
	
	
}
