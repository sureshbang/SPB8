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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.TC48_PropertyPage_POM;

public class RETC_079 {
	
	static final Logger log= Logger.getLogger(RETC_079.class);
		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private static Properties properties;
		private ScreenShot screenShot;
		private TC48_PropertyPage_POM TC48_PropertyPage_POM;
		private static ExtentReports extent;
		private ExtentTest logger;
		

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			extent = new ExtentReports("C:\\JAVA\\Selenium\\Project\\RETC_048\\RETC_079.html");
			
		}

		@BeforeMethod
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new LoginPOM(driver); 
			TC48_PropertyPage_POM = new TC48_PropertyPage_POM(driver);
			//UsersPageRETC_76_POM = new UsersPageRETC_76_POM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		
		
	  @Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	  public void userCreation(String username,String password,String nameTextBox,String slugTextBox, String parentRegion, String descriptionTextArea) throws InterruptedException 
	      {
			logger =extent.startTest("login test");
			logger.log(LogStatus.INFO," login test");
		    loginPOM.loginlinkclick();
			loginPOM.sendUserName(username);
			logger.log(LogStatus.PASS," Username entered");
			loginPOM.sendPassword(password);
			loginPOM.clickLoginBtn(); 
			logger.log(LogStatus.PASS," Logged in correctly");
			screenShot.captureScreenShot("TC79_1");
			
			Thread.sleep(4000);
			String a =driver.getTitle();
			System.out.println(a);
			//Thread.sleep(4000);
			TC48_PropertyPage_POM.propertyMenuItemClick();
			Thread.sleep(4000);
			logger.log(LogStatus.PASS," Properties Clicked Perfectly");
			TC48_PropertyPage_POM.featuresMenuItemLinkclick();			
			System.out.println("...clicked features link successfully ........");
			TC48_PropertyPage_POM.nameTextBoxEnterValue(nameTextBox);
			
			TC48_PropertyPage_POM.slugTextBoxEnterValue(slugTextBox);
			logger.log(LogStatus.PASS," Slug Entered Perfectly");
			TC48_PropertyPage_POM.parentFeatureSelectionDropdown(parentRegion);
			logger.log(LogStatus.PASS," Parent region entered Perfectly");
			TC48_PropertyPage_POM.descriptionTextAreaEnter(descriptionTextArea);
			TC48_PropertyPage_POM.addNewfeatureButtonClick();
			
			logger.log(LogStatus.PASS," Add New Feature Button Clicked Perfectly");
			
			//a[text()='— ssssssss']
			
			
			driver.navigate().refresh();
			Thread.sleep(5000);
			
			String before = "//a[text()='— ";
            String after ="']";
			
            WebElement a1 = driver.findElement(By.xpath(before+nameTextBox+after));	
            
           String nameDisplayed = a1.getText();
           
           System.out.println("Feature Name  is added--------------" + nameDisplayed);
           String nametextWithSpace = "— "+nameTextBox;
           Assert.assertEquals(nameDisplayed, nametextWithSpace, "Test case is passed");
           
		    System.out.println("name in text box "+ nameTextBox + " features "+ nameDisplayed);
		    
		    
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