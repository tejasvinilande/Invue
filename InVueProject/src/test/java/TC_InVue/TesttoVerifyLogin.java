package TC_InVue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import PO_Functions.BaseClass;
import PO_Functions.LoginPage;



public class TesttoVerifyLogin extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		log=report.createTest("Login");
		
		LoginPage lp=new LoginPage(driver);
		lp.login();
	
		
		if(driver.getTitle().equals("InVue Access Manager")) {
			
			captureScreen(driver,"loginTest");
			Assert.assertTrue(true);
			log.pass("Login Passed!", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen(driver,"loginTest")).build());
			logger.info("Login Test passed");
			
		}
		
		else
		{
			Assert.assertTrue(false);
			log.fail("login Failed", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen(driver,"loginTest")).build());
			logger.info("Login Test failed");
		}
	}
	
}
