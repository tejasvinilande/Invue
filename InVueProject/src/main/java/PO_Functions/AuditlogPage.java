package PO_Functions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuditlogPage extends WebElementActions{

	WebDriver driver;

	public AuditlogPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//p[contains(text(),'Audit')]")
	WebElement lnkAudit;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement Searchlog;
	
	@FindBy(xpath="//span[contains(text(),'Logged in to Mobile App')]")
	WebElement login;
	
	@FindBy(xpath="//span[contains(text(),'Logged out from Mobile App')]")
	WebElement logout;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/nav/div[2]/div/div[1]/div[2]/div[2]/input")
	WebElement fromdate;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/nav/div[2]/div/div[1]/div[3]/div[2]/input")
	WebElement Todate;
	
	public void clickaudit() {
		lnkAudit.click();
		logger.info("Clicked On Audit!!");
	}
	
	public void searchlog(String log) {
		Searchlog.sendKeys(log);
	}
	
	
	
	public void verifylogin() {
		
		if(login.isDisplayed()) {
			
			logger.info("Login of device displayed!!");	
			
		}
		
	}
	
	public void verifylogout() {
		
		if(logout.isDisplayed()) {
			
			logger.info("Logout of device displayed!!");	
			
		}
		
	}
	
	public void fromdate() throws Exception {
		
		String sDate = fromdate.getAttribute("value");
		logger.info("From Date is:-"+sDate);
		
	}
	
	public void todate() throws Exception {
		
		
		String ActualDate = Todate.getAttribute("value");
		logger.info("To date is:-"+ActualDate);
		
		DateFormat dateFormat1 = new SimpleDateFormat("MM-dd-yyyy");
		DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
		String todayFormat1 = dateFormat1.format(new Date());
		String todayFormat2 = dateFormat2.format(new Date());
		System.out.println("Today's date in format 1: "+ todayFormat1);
        if(!(todayFormat1.equals(ActualDate) || todayFormat2.equals(ActualDate))) { 
        	throw new Exception("Wrong date displayed");
		 }
     
	}
	public void auditlog() throws Exception {
		clickaudit();
		searchlog("Mrudul MultipleStore");
		verifylogin();
		verifylogout();
		fromdate();
		todate();
	}
	
	


}
