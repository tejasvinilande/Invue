package TC_InVue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PO_Functions.BaseClass;
import PO_Functions.LoginPage;



public class TesttoVerifyLogin extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		
		LoginPage lp=new LoginPage(driver);
		lp.login();
	
		
		if(driver.getTitle().equals("InVue Access Manager")) {
			
			captureScreen(driver,"loginTest");
			Assert.assertTrue(true);
			logger.info("Login Test passed");
		}
		
		else
		{
			Assert.assertTrue(false);
			logger.info("Login Test failed");
		}
	}
	
}
