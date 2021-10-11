package TC_InVue;

import java.io.IOException;

import org.testng.annotations.Test;

import PO_Functions.AddNewUserPage;
import PO_Functions.BaseClass;
import PO_Functions.EditUserPage;
import PO_Functions.LoginPage;

public class TesttoEditUser extends BaseClass {
	
	
	@Test
	public void EditUser() throws  IOException, InterruptedException 
	{
	LoginPage lp=new LoginPage(driver);
	lp.login();
	logger.info("login successful");
	
	EditUserPage user=new EditUserPage(driver);
	user.Edituser();

	
	}

}
