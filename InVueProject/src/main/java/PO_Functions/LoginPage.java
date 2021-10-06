package PO_Functions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

          WebDriver driver;
          public static Logger logger = Logger.getLogger(LoginPage.class);
          
          
	
		public LoginPage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver,this);
			PropertyConfigurator.configure("log4j.properties");
		}
	
		
		
	@FindBy(xpath="//input[@class='login-input-field'][1]")
	WebElement txtusername;
	
	@FindBy(xpath="//*[@id='app']/div/div[2]/div[2]/form/div[2]/div/input")
	WebElement txtpassword;
	
	@FindBy(xpath="//span[@class='button_label']")
	WebElement btnlogin;
	
	
	
	public void setUserName(String uname) {
		
		txtusername.sendKeys(uname);
		logger.info("username entered.");
		
	} 
	
	
    public void setPassword(String pwd) {
		
		txtpassword.sendKeys(pwd);
		logger.info("Password entered.");
		
	}
	
    public void ClickLogin() {
	
	   btnlogin.click();
	   logger.info("succesfully click on login.");
	   
	
    }
    public void login() {
    	
           setUserName("superadmin");
    	   setPassword("Superadmin2015");
           ClickLogin();
    	
    	
    }

	
	
	
}

	

