package PO_Functions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditZonePage extends WebElementActions{

	WebDriver driver;
	public static Logger logger = Logger.getLogger(EditZonePage.class);

	
	public EditZonePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@FindBy(xpath = "//p[contains(text(),'Zones')]")
	WebElement lnkZone;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/input")
	WebElement txtSearchZone;
	
	@FindBy(xpath = "//h2[contains(text(),'Test Zone (0)')]")
	WebElement selectzone;
	
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
	
	public void searchzone(String zone) {
		txtSearchZone.sendKeys(zone);;
		logger.info("zone searched!!");
	}
	
	public void selectzone() {
		
		if(selectzone.isDisplayed()) {
			
			logger.info("zone is present");	
		}
		else {
			
			logger.info("Zone is not Displyed!!");
			
		}
		
		selectzone.click();
		logger.info("Zone selected!!");
	}

	public void editzonename(String zname) {
		txtzonename.clear();
		txtzonename.sendKeys(zname);
		logger.info("zone name edited!!");
	}
	
	public void editdesc(String desc) {
		txtzonedesc.clear();
		txtzonedesc.sendKeys(desc);
		logger.info("Desc changed!!");
	}
	
	public void clicksave() {
		btnSavezone.click();
		logger.info("Zone saved!!");
	}
	
	public void Editzone() throws InterruptedException {
		clickzone();
		Thread.sleep(5000);
		searchzone("Test Zone");
		Thread.sleep(5000);
		selectzone();
		editzonename(" test zone ");
		editdesc("Test for Editing zone.");
		clicksave();
		
	}
}
