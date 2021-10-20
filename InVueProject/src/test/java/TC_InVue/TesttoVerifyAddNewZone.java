package TC_InVue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import PO_Functions.AddNewUserPage;
import PO_Functions.AddNewZonePage;
import PO_Functions.BaseClass;
import PO_Functions.LoginPage;

public class TesttoVerifyAddNewZone extends BaseClass {

	@Test
	public void AddNewZone() throws  IOException, InterruptedException 
	{
		
		log=report.createTest("NewZone");
		
		LoginPage lp=new LoginPage(driver);
		lp.login();
		logger.info("login successful");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AddNewZonePage newzone=new AddNewZonePage(driver);
		newzone.addnewzone();
		
		logger.info("Zone created");
		captureScreen(driver,"AddNewZone");
		log.pass("Zone Added!", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen(driver,"NewZoneTest")).build());
	
		
	}
	
}
