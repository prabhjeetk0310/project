package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseTest;
import pompackage.PomSignIn;

public class SignInTest extends BaseTest{

	
	PomSignIn Signin;
	//PomYourAccount YourAccount;

	public SignInTest() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiate();
		Signin = new PomSignIn();
	
	}

	
	 @Test(priority=1) 
	 public void Title() { 
		 String actual=Signin.verify();
	  System.out.println(actual);
	  Assert.assertEquals(actual, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
	  }
	 
	@Test(priority = 2)
	public void login() throws InterruptedException {
	 Signin.login(prop.getProperty("emailormob"), prop.getProperty("pass"));
		screenshots("Signin");
	}

	@Test(priority = 3)
	public void verifylogo() {
		Signin.validatestoreLogo();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
