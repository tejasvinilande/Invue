package TC_InVue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PO_Functions.AuditlogPage;
import PO_Functions.BaseClass;
import PO_Functions.LoginPage;

public class TesttoVerifyAuditlogs  extends BaseClass {


	@Test
	public void TesttoVerifyAuditlogs() throws  Exception 
	{
		
			
		LoginPage lp=new LoginPage(driver);
		lp.login();
		logger.info("login successful");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AuditlogPage log =new AuditlogPage(driver);
		log.auditlog();
		
		
	}
		
}
