package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseTest;

public class PomSignIn  extends BaseTest{
	@FindBy(css = "#nav-link-accountList")
	WebElement AccountandLists;
	
	@FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']" )
    WebElement SignIn ;
	
	
	@FindBy(xpath = "//input[@id='ap_email']" )
    WebElement Email  ;
	
	@FindBy(xpath = "//input[@id='continue']" )
    WebElement Continue1 ;
	
	@FindBy(xpath = "//input[@id='ap_password']")
    WebElement Pswd  ;
	
	@FindBy(xpath = "//input[@id='signInSubmit']" )
    WebElement Continue2;
	
	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	WebElement Storelogo;


	public PomSignIn () {
		PageFactory.initElements(driver, this);

	}

	public boolean validatestoreLogo() {
		return Storelogo.isDisplayed();
	}

	public void login(String emailormob, String pass) throws InterruptedException {

		AccountandLists.click();
		// SignIn.click();
		Email.sendKeys(emailormob);
		Continue1.click();
		Pswd.sendKeys(pass);
		Continue2.click();
		Thread.sleep(2000);
		

	}

	public String verify() {
		return driver.getTitle();
	}
}