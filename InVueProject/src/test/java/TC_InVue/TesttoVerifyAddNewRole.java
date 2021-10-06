package TC_InVue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PO_Functions.AddNewRolePage;
import PO_Functions.AddNewUserPage;
import PO_Functions.BaseClass;
import PO_Functions.LoginPage;

public class TesttoVerifyAddNewRole extends BaseClass{
	
	@Test
	public void AddNewRole() throws  IOException, InterruptedException 
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.login();
		logger.info("login successful");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AddNewRolePage newrole=new AddNewRolePage(driver);
		newrole.addNewRole();
		logger.info("Role created");
		//captureScreen(driver,"AddNewRole");
		
	}

}
