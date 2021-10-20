package TC_InVue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import PO_Functions.AddNewUserPage;
import PO_Functions.BaseClass;
import PO_Functions.EditZonePage;
import PO_Functions.LoginPage;

public class TesttoVerifyEditZone extends BaseClass {

	@Test
	public void Editzone() throws  IOException, InterruptedException 
	{
		
		log=report.createTest("EditZone");
		
		LoginPage lp=new LoginPage(driver);
		lp.login();
		logger.info("login successful");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		EditZonePage editzone=new EditZonePage(driver);
		editzone.Editzone();
		
		WebElement zone=driver.findElement(By.xpath("//h2[contains(text(),'test zone (0)')]"));
		
		if(zone.isDisplayed()) {
			
			logger.info("zone is updated!!");	
			log.pass("Zone is Updated!", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen(driver,"EditZone")).build());
		}
		else {
			
			logger.info("Zone is not updated!!");
			log.fail("Zone is not Edited!", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen(driver,"EditZone")).build());
			
		}
		
		
		captureScreen(driver,"Editzone");
	
		
	}
}
