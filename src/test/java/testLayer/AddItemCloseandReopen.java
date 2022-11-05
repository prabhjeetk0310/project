package testLayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseTest;
import pompackage.PomAddItemCloseandReopen;

public class AddItemCloseandReopen extends BaseTest {
	
	PomAddItemCloseandReopen AddItemCloseandReopen;
	public AddItemCloseandReopen() {
		super();
	}
	@BeforeMethod
	public void initseup() throws InterruptedException {
	initiate();
	Thread.sleep(500);
	screenshots("Shopping cart");
}

	@Test
	public void verifyCloseReopen() throws InterruptedException  {
		AddItemCloseandReopen=new PomAddItemCloseandReopen();
		AddItemCloseandReopen.closeReopenTest();

}
	
	@AfterMethod  
	public void close() {
		driver.quit();
	}

}
