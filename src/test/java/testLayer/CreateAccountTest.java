package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseTest;
import pompackage.PomCreateAccount;
import testData.ExcelSheet1;


public class CreateAccountTest  extends BaseTest {
     
	PomCreateAccount account;
	
	
	public CreateAccountTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() throws InterruptedException {
		initiate();
		account  = new PomCreateAccount();
		/*account.CreateAccount1();
		account.typeyourname("Prabh");
		account.typemobilenooremail("gillprabh574@gmail.com");
		account.typepassword("Prabh1234");
		account.typepasswordagain("Prabh1234");
		account.clickbtn();
		*/
		screenshots("CreateAccount");
	
	
}
	@Test(priority = 1)
	public void Title() {
		String actual = account.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
	}
	
@DataProvider
	
	public Object [][] Details(){
		
		Object result[][] = ExcelSheet1.readdata("Sheet1");
		
		return result;
	}
@Test(priority =2 ,dataProvider = "Details")

public void CAlogin(String name, String emailormob, String pass, String passA) throws InterruptedException 
{
	account.CreateAccountlogin(name, emailormob, pass, passA) ;
/*	
	account.CreateAccount1();
	account.typeyourname(name);
	account. typemobilenooremail(emailormob);
	account.typepassword(pass);
	account.typepasswordagain(passA);
	account.clickbtn();
	account.SignInbtn();
	account.Email(emailormob);
	account.ContBtn();
	account.pswdbtn(pass);
	account.Signbtn();
	
	*/
}
	
	@Test(priority = 3)
	public void verifylogo() {
		account.validateLogo();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
	
}

