package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UsersPageRETC_76_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_078 {
	
	static final Logger log= Logger.getLogger(RETC_078.class);
		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private static Properties properties;
		private ScreenShot screenShot;
		//private TC48_PropertyPage_POM TC48_PropertyPage_POM;
		private static ExtentReports extent;
		private ExtentTest logger;
		//private RETC_047_POM RETC_047_POM;
		private UsersPageRETC_76_POM UsersPageRETC_76_POM;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			extent = new ExtentReports("C:\\JAVA\\Selenium\\Project\\RETC_048\\RETC_078.html");
			
		}

		@BeforeMethod
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new LoginPOM(driver); 
			//TC48_PropertyPage_POM = new TC48_PropertyPage_POM(driver);
			UsersPageRETC_76_POM = new UsersPageRETC_76_POM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		
		
	  @Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	  public void userCreation(String username,String password,String user, String first,String last, String email, String website, String pass
			  ) throws InterruptedException 
	      {
			logger =extent.startTest("login test");
			logger.log(LogStatus.INFO," login test");
		    loginPOM.loginlinkclick();
			loginPOM.sendUserName(username);
			logger.log(LogStatus.PASS," Username entered");
			loginPOM.sendPassword(password);
			loginPOM.clickLoginBtn(); 
			logger.log(LogStatus.PASS," Logged in correctly");
			screenShot.captureScreenShot("TC78_1");
			
			//Thread.sleep(4000);
			String a =driver.getTitle();
			System.out.println(a);
			UsersPageRETC_76_POM.userLinkClick();
			System.out.println("clicked users");
			UsersPageRETC_76_POM.addNewclick();
			
			UsersPageRETC_76_POM.newUserName(user);
			UsersPageRETC_76_POM.newFirstName(first);
			UsersPageRETC_76_POM.newLastName(last);
			UsersPageRETC_76_POM.newEmail(email);
		    UsersPageRETC_76_POM.newURL(website);
		    UsersPageRETC_76_POM.showPasswordBtn();
		    UsersPageRETC_76_POM.newPassword(pass);
		   // UsersPageRETC_76_POM.weakPasswordClick();
		    UsersPageRETC_76_POM.hideButton();
		    UsersPageRETC_76_POM.cancelButton();
		    UsersPageRETC_76_POM.roleSelectBox();
		    Thread.sleep(4000);
		    UsersPageRETC_76_POM.newUserCreateButtonClick();
		    Thread.sleep(4000);
		   // UsersPageRETC_76_POM.newUserCreatedMsg();
		    
		    
		    String m= UsersPageRETC_76_POM.errorTextMsg();		    
		    System.out.println("error msg displayed is--------------" + m);
		    
		    
		/*
		 * String before = "//a[contains(text(),'"; String after = "')]"; String
		 * username1 = first;
		 * 
		 * WebElement a1 = driver.findElement(By.xpath(before+username1+after));
		 * 
		 * String b1=a1.getText(); Assert.assertEquals(username1,b1);
		 * System.out.println("pass 76");
		 */
					  
			  
			
			
	      }
		    
		  
	      
	  @AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
		driver.quit();
	                   }
	}