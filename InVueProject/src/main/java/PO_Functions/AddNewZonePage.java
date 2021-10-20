package PO_Functions;

import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewZonePage extends WebElementActions {
	
	WebDriver driver;
	  public static Logger logger = Logger.getLogger(AddNewZonePage.class);

	public AddNewZonePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@FindBy(xpath = "//p[contains(text(),'Zones')]")
	WebElement lnkZone;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/nav/div[1]/div[1]/button/span")
	WebElement lnkAddZone;
	
	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[1]/input")
	WebElement txtzonename;
	
	@FindBy(xpath = "//*[@id=\"scroller\"]/div/div[2]/input")
	WebElement txtzonedesc;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement btnSavezone;
	
	public void clickzone() {
		lnkZone.click();
		logger.info("clicked on zone!!");
		
	}
	
	public void clickaddzone() {
		lnkAddZone.click();
		logger.info("clicked on Add New Zone!!");
	}
	
	public void zonename(String Zname) {
		txtzonename.sendKeys(Zname);
		logger.info("zone Name Entered!!");
	}
	
	public void zonedesc(String desc) {
		txtzonedesc.sendKeys(desc);
		logger.info("Zone description Added!!");
	}

	public void clicksave() {
		btnSavezone.click();
		logger.info("clicked on save Zone!!");
		
	}
	
	public void addnewzone() {
		Random random = new Random();
		clickzone();
		clickaddzone();
		zonename("Test Zone" + + random.nextInt(10));
		zonedesc("This is for Testing purpose" );
		clicksave();
		
		
	}
}
