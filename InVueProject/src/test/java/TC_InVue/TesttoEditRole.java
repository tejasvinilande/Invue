package TC_InVue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import PO_Functions.BaseClass;
import PO_Functions.EditRolePage;
import PO_Functions.LoginPage;

public class TesttoEditRole extends BaseClass {

	@Test
	public void Editrole() throws  IOException, InterruptedException 
	{
		
	
		LoginPage lp=new LoginPage(driver);
		lp.login();
		logger.info("login successful");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		EditRolePage role=new EditRolePage(driver);
		role.EditRole();
		logger.info("Role Edited!!");
		
		captureScreen(driver,"EditRole");
	
		
	}
	
		
		
	
}
