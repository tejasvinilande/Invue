package TC_InVue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import PO_Functions.AddNewUserPage;
import PO_Functions.BaseClass;
import PO_Functions.EditUserPage;
import PO_Functions.LoginPage;

public class TesttoEditUser extends BaseClass {
	
	
	@Test
	public void EditUser() throws  IOException, InterruptedException 
	
	{
		
	log=report.createTest("EditUser");
	
	LoginPage lp=new LoginPage(driver);
	lp.login();
	logger.info("login successful");
	
	EditUserPage user=new EditUserPage(driver);
	user.Edituser();
	log.pass("User Edited!", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen(driver,"EditUser")).build());

	
	}

}
