package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import basePackage.BaseTest;

public class PomCreateAccount extends BaseTest {

	 @FindBy(xpath = "//span[normalize-space()='Account & Lists']")
	        WebElement AccountandLists;
	 @FindBy(xpath = "//div[@id='nav-flyout-ya-newCust']//a[@class='nav-a'][normalize-space()='Start here.']")
	 WebElement CreateAccountSubmit ;
	 @FindBy(css = "#ap_customer_name")
	 WebElement YourName;
	 @FindBy ( xpath = "//input[@id='ap_email']")
	 WebElement MobileorEmail;
	 @FindBy ( xpath = "//input[@id='ap_password']")
	 WebElement  Pswd;
	 @FindBy (xpath = "//input[@id='ap_password_check']" )
	 WebElement PswdAgain;
	 @FindBy ( xpath = "//input[@id='continue']")
	 WebElement  ContinueBtn;
	 @FindBy ( xpath = "//input[@id='cvf-input-code']")
	 WebElement  EnterOTP;
	 @FindBy ( xpath = "//input[@aria-labelledby='cvf-submit-otp-button-announce']")
	 WebElement  CreateAccountbtn;
	 
	 @FindBy ( xpath  = "//a[normalize-space()='Sign-In'] ")
	 WebElement  SignInBtn;
	 @FindBy ( xpath = "//input[@id='ap_email']")
	 WebElement Email ;
	 @FindBy ( xpath = "//input[@id='continue']")
	 WebElement ClickBtn1 ;
	 
	 @FindBy ( xpath = "//input[@id='ap_password']")
	 WebElement Password;
	 @FindBy ( xpath = "//input[@id='signInSubmit']")
	 WebElement ClickBtn2;

	 @FindBy ( xpath = "//a[@id='nav-logo-sprites']")
	 WebElement  Amazonlogo;
	 
	 
	 
	
	//initiate page elements
		public PomCreateAccount() {
			PageFactory.initElements(driver, this);

		}

	 
		 public void CreateAccount1() throws InterruptedException  {
			 Actions action=new Actions(driver); 
			 action.moveToElement(AccountandLists).build().perform();
				 Thread.sleep(2000);
				 action.moveToElement(CreateAccountSubmit).click().build().perform();
				 Thread.sleep(2000); } 
		 
		 public void typeyourname(String name) {
			YourName.sendKeys(name); } 
		 public void typemobilenooremail(String mobilenoemail) { 
			 MobileorEmail.sendKeys(mobilenoemail); }
		 public void typepassword(String pass) { 
			 Pswd.sendKeys(pass); } 
		 public void typepasswordagain(String passA) {
			 PswdAgain.sendKeys(passA); } 
		 public void clickbtn() { 
			 ContinueBtn.click();}
		 public void SignInbtn() { 
			 SignInBtn.click();}
		 public void Email(String emailormob) { 
			 Email.sendKeys(emailormob);}
		 public void ContBtn() { 
			 ClickBtn1.click();}
		 public void pswdbtn(String passwd) { 
			 Password.sendKeys(passwd);}
		 public void Signbtn() { 
			 ClickBtn2.click();}    
			 
			 
		 
		public  void CreateAccountlogin (String name, String emailormob, String pass, String passA) throws InterruptedException {
			Actions action = new Actions(driver);
			action.moveToElement(AccountandLists).build().perform();
			Thread.sleep(2000);
			action.moveToElement(CreateAccountSubmit).click().build().perform();
			Thread.sleep(2000);
			YourName.sendKeys(name);
			MobileorEmail.sendKeys(emailormob);
			Pswd.sendKeys(pass);
			PswdAgain.sendKeys(passA);
			ContinueBtn.click();
			
			SignInBtn.click();
			Email.sendKeys(emailormob);
			ClickBtn1.click();
			Password.sendKeys(pass);
			ClickBtn2.click();
			
		}

			
		// verify page title
			
			public  String verify ()
			{
				return driver.getTitle();
			}
	// verify Amazon logo  displayed
			
			public boolean validateLogo() {
				
			
				return Amazonlogo.isDisplayed();
			}
			
			
		
			
			
			
			
		
}



