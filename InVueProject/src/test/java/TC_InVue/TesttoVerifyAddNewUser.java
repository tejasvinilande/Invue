package TC_InVue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import PO_Functions.AddNewUserPage;
import PO_Functions.BaseClass;
import PO_Functions.LoginPage;



public class TesttoVerifyAddNewUser extends BaseClass {

	@Test
	public void AddNewUser() throws  IOException, InterruptedException 
	{
		
		log=report.createTest("NewUser");
		LoginPage lp=new LoginPage(driver);
		lp.login();
		logger.info("login successful");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AddNewUserPage newuser=new AddNewUserPage(driver);
		newuser.Adduser();
		
		log.pass("User Created!", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen(driver,"NewUserTest")).build());
		logger.info("user created");
		captureScreen(driver,"AddNewUser");
	
		
	}

	
}
