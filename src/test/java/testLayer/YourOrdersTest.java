package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseTest;
import pompackage.PomSignIn;
import pompackage.PomYourAccount;
import pompackage.PomYourOrders;

public class YourOrdersTest  extends BaseTest {

	PomSignIn Signin;
	PomYourAccount YourAccount;
	PomYourOrders YourOrders;

	public YourOrdersTest() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiate();
		Thread.sleep(2500);
		Signin = new PomSignIn();
		// SignIn=new PomCreateAccount();
		// SignIn.act();
		// YourAccount=SignIn.login(prop.getProperty("name"),prop.getProperty("emailormob"),prop.getProperty("pass"),prop.getProperty("passA"));
		Signin.login(prop.getProperty("emailormob"), prop.getProperty("pass"));
		YourAccount.act1();
		YourOrders = YourAccount.ClickonYourOrders();
		// YourOrders.ClickonOrders();
		screenshots("YourOrders");
	}

	@Test(priority = 1)
	public void Title() {
		String actual = YourOrders.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Your Orders", "YourOrderpage title is not matched");
	}

	@Test(priority = 5)
	public void testOrdersLink1() {
		// YourOrders.ClickonOrders();
		YourOrders.orderfilter1();
	}

	@Test(priority = 6, enabled = false)
	public void testOrdersLink2() {
		// YourOrders.ClickonOrders();
		YourOrders.orderfilter2();
		// screenshots("order@2022");
	}

	@Test(priority = 7, enabled = false)
	public void testOrdersLink3() {
		// YourOrders.ClickonOrders();
		YourOrders.orderfilter3();
	}

	@Test(priority = 2)
	public void testBuyAgainLink() {
		YourOrders.ClickonBuyAgain();

	}

	@Test(priority = 3)
	public void testCancelledorderLink() {
		YourOrders.ClickonCancelledOrders();
		// Assert.assertEquals(actual, "Your Orders","YourOrderpage title is not
		// matched");

	}

	@Test(priority = 4)
	public void testNotyetShipped() {
		YourOrders.ClickonNotYetShipped();

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
