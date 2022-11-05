package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseTest {

	public static Properties prop = new Properties();  // will help to read data from config.properties file
	 
	 public static WebDriver driver;
	 
	//constructor of BaseTest
		public BaseTest()
		{
			
			try {
				
				//load data from Config.properties file
			
			FileInputStream file = new FileInputStream("C:\\Users\\Gagan\\Documents\\java selenium\\Amazon\\src\\test\\java\\environmentVariables\\Config.properties");
		prop.load(file);
		}
			catch(FileNotFoundException a) {
			a.printStackTrace();
		
			}
			
			catch(IOException e) {
		e.printStackTrace();
			}
		}
	
//browser initiation
		
		public static void initiate() {
			
			String browsername = prop.getProperty("browser");
			if (browsername.equals("Chrome")) {
				
				System.setProperty("WebDriver.Chrome.Driver", "chromeDriver.exe");
				driver = new ChromeDriver();
			}
			
			else if (browsername.equals("Firefox")) {
				
				System.setProperty("WebDriver.gecko.Driver", "geckoDriver.exe");
				driver = new FirefoxDriver();
			}

driver.manage().window().maximize();
driver.manage().deleteAllCookies();
	
driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(TimeUtils.implicitWait,TimeUnit.SECONDS);
	
driver.get(prop.getProperty("url"));
driver.navigate().refresh();
	
		}
		
		public static void screenshots (String Filename) 

		{
			File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(srcfile,new File ("C:\\Users\\Gagan\\Documents\\java selenium\\Amazon\\src\\test\\java\\screenshots\\Screenshots"+Filename+".jpg" ));
			}
			catch (IOException a) {
				
				a.printStackTrace();
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
