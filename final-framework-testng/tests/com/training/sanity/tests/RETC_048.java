package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.TC48_PropertyPage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_048 {
	
//static final logger log= new logger(RETC_048.class);
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private TC48_PropertyPage_POM TC48_PropertyPage_POM;
	//private static ExtentReports extent;
	//private ExtentTest logger;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		//extent = new ExtentReports("C:\\JAVA\\Selenium\\Project\\RETC_048\\RETC_048.html");
		
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		TC48_PropertyPage_POM = new TC48_PropertyPage_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	
  @Test
  public void properties() throws InterruptedException 
      {
		//logger =extent.startTest("login test");
	  
		//logger.log(LogStatus.INFO," loggin test");
	    loginPOM.loginlinkclick();
		loginPOM.sendUserName("admin");
		//logger.log(LogStatus.PASS," Username entered");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn(); 
		//logger.log(LogStatus.PASS," Logged in correctly");
		screenShot.captureScreenShot("First");
		TC48_PropertyPage_POM.propertiesLinkclick();
		TC48_PropertyPage_POM.addNewButtonclick();	
		TC48_PropertyPage_POM.addNewRegionLinkClick();
		TC48_PropertyPage_POM.addTextInTextBox("Ramamurthynagar");
		TC48_PropertyPage_POM.parentTypeDropDown();
		
		TC48_PropertyPage_POM.addNewRegionButtonClick();
		//Thread.sleep(5000);
		driver.navigate().refresh();
		
		
		  TC48_PropertyPage_POM.enterTileText("prestige48");
		  TC48_PropertyPage_POM.textAreaBox("home town48"); 
		  TC48_PropertyPage_POM.regionCheckkBox();
		  //Thread.sleep(5000);
		  
		  TC48_PropertyPage_POM.publishButtonClick();
		 System.out.println(" !! Congrats !! Suresh- RETC 048 Test case is Passed ");
		
      }
	    
	  
      
  @AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
                   }
}