package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseTest;
import pompackage.PomLogin_and_Security;
import pompackage.PomSignIn;

public class LoginAndSecurityTest extends  BaseTest {

	
	PomSignIn Signin;
	
	PomLogin_and_Security LoginandSecurity;

	public LoginAndSecurityTest() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiate();
		Thread.sleep(500);
		Signin = new PomSignIn();
		
		Signin.login(prop.getProperty("emailormob"), prop.getProperty("pass"));

		// Signin.login(prop.getProperty("name"),prop.getProperty("emailormob"),prop.getProperty("pass"),prop.getProperty("passA"));
		
		//LoginandSecurity = YourAccount.ClickonLoginandSecurity();
		// YourOrders.ClickonOrders();
		screenshots("Login And Security");
	}

	@Test(priority = 1)
	public void Title() {
		String actual = LoginandSecurity.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Amazon Change Name, E-mail, Password", " Login & security title is not matched");
	}

	
	@AfterMethod
	public void close() {
		driver.quit();
	}
}

